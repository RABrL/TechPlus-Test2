import type { APIRoute } from 'astro'
import { BigQuery } from '@google-cloud/bigquery'

import { queryBuilder } from '@/lib/query'
import type { QueryBuilderProps } from '@/lib/types'

export const prerender = false

const bigquery = new BigQuery({
  projectId: import.meta.env.PROJECT_ID,
  keyFilename: import.meta.env.BIGQUERY_CREDENTIALS_FILE
})

export const POST: APIRoute = async ({ request }) => {
  const query = queryBuilder((await request.json()) as QueryBuilderProps)
  console.log(query)
  const options = {
    query,
    // Location must match that of the dataset(s) referenced in the query.
    location: 'US'
  }

  // Run the query
  let rows
  try {
    ;[rows] = await bigquery.query(options)
  } catch (err) {
    console.log('BIGQUERY ERROR: ', err)
    return new Response(
      JSON.stringify({ message: 'Error fetching the query' }),
      { status: 400 }
    )
  }

  return new Response(JSON.stringify({ rows, query }), { status: 200 })
}
