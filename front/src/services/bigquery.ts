import { BigQuery } from '@google-cloud/bigquery'

export async function queryStackOverflow() {
  // Queries a public Stack Overflow dataset.

  // Create a client
  const bigquery = new BigQuery({
    projectId: 'techplus-stage2',
    keyFilename: '/home/brito/Dev/tech+-test2/front/bigquery-key.json'
  })

  // The SQL query to run
  const sqlQuery = `SELECT
    CONCAT(
      'https://stackoverflow.com/questions/',
      CAST(id as STRING)) as url,
    view_count
    FROM \`bigquery-public-data.stackoverflow.posts_questions\`
    WHERE tags like '%google-bigquery%'
    ORDER BY view_count DESC
    LIMIT 10`

  const options = {
    query: sqlQuery,
    // Location must match that of the dataset(s) referenced in the query.
    location: 'US'
  }

  // Run the query
  const [rows] = await bigquery.query(options)

  console.log('Query Results:')
  rows.forEach((row) => {
    const url = row.url
    const viewCount = row.view_count
    console.log(`url: ${url}, ${viewCount} views`)
  })
}

