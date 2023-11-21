import { BigQuery } from '@google-cloud/bigquery'

const bigquery = new BigQuery({
  projectId: 'techplus-stage2',
  keyFilename: '/home/brito/Dev/tech+-test2/front/bigquery-key.json'
})

const DB_NAME = 'bigquery-public-data.sdoh_cdc_wonder_natality'

export enum TABLE_NAME {
  abnormal_conditions = 'county_natality_by_abnormal_conditions',
  default = 'county_natality'
}

interface whereProps {
  anormal_Conditions_Checked_YN?: boolean
  Ave_Age_of_Mother?: number
  Ave_Birth_Weight_gms?: number
  County_of_Residence: string
  Mothers_Single_Race?: string
  Year?: string
}

interface likeProps {
  County_of_Residence: string
  Mothers_Single_Race?: string
}

type selectProps = keyof whereProps | '*' | 'Births'

interface QueryBuilderProps {
  limit?: number
  where?: whereProps
  select?: selectProps[]
  like?: likeProps
  tableName?: TABLE_NAME
  join?: {
    tableName: TABLE_NAME
    on: string
  }
}

export async function fetchQuery({
  limit = 10,
  where,
  select,
  like,
  tableName = TABLE_NAME.default,
  join
}: QueryBuilderProps) {
  const whereQuery = parseWhere(where)
  const likeQuery = parseLike(like)
  const selectQuery = select ? select.join(', ') : '*'

  const sqlQuery = `SELECT ${selectQuery}
    FROM \`${DB_NAME}.${tableName}\`
    ${join ? `JOIN ${DB_NAME}.${join.tableName} ON ${join.on}` : ''}
    ${where ? `WHERE ${whereQuery}` : ''}
    ${like ? `LIKE ${likeQuery}` : ''} 
    LIMIT ${limit}`

  const options = {
    query: sqlQuery,
    // Location must match that of the dataset(s) referenced in the query.
    location: 'US'
  }

  // Run the query
  const [rows] = await bigquery.query(options)
  console.log(rows)
  console.log('Query Results:')
  rows.forEach((row) => {
    const county = row.County_of_Residence
    console.log(`county: ${county}`, `rows: ${JSON.stringify(rows.length)}`)
  })
}

const parseWhere = (where?: whereProps) => {
  if (!where) return ''
  return Object.entries(where)
    .map(([key, value]) => {
      if (typeof value === 'string') return `${key} = '${value}'`
      return `${key} = ${value}`
    })
    .join(' AND ')
}
const parseLike = (like?: likeProps) => {
  if (!like) return ''
  Object.entries(like)
    .map(([key, value]) => {
      return `${key} LIKE '%${value}%'`
    })
    .join(' AND ')
}
