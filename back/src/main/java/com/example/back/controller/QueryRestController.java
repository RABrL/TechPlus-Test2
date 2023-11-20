package com.example.back.controller;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/bigquery")
public class QueryRestController {
    @GetMapping("/test")
    public ResponseEntity test() throws InterruptedException, IOException {
        String jsonPath = "/home/brito/Dev/tech+-test2/back/bigquery-key.json";
        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(jsonPath));
        BigQuery bigQuery = BigQueryOptions.newBuilder().setProjectId("techplus-stage2").setCredentials(credentials).build().getService();

        final  String query = "" +
                "SELECT SUM(Births) as births FROM bigquery-public-data.sdoh_cdc_wonder_natality.county_natality WHERE Year = '2018-01-01'";

        QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();

        Job queryJob = bigQuery.create(JobInfo.newBuilder((queryConfig)).build());

        queryJob = queryJob.waitFor();

        if(queryJob == null) {
            throw new RuntimeException("Job no longer exists");
        }
        if (queryJob.getStatus().getError() != null) {
            throw new RuntimeException(queryJob.getStatus().getError().toString());
        }

        TableResult result = queryJob.getQueryResults();
        HashMap res = new HashMap();

        for (FieldValueList row : result.iterateAll()) {
            String births = row.get("births").getStringValue();
            res.put("births", births);
        }

        return ResponseEntity.ok(res);
    }
}
