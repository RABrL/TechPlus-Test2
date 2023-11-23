import { DB_NAME, TABLE_NAME } from "@/lib/definitions"
import type { QueryBuilderProps, likeProps, whereProps } from "@/lib/types"

export const parseWhere = (where?: whereProps) => {
  if (!where) return ''
  return Object.entries(where)
    .map(([key, value]) => {
      if (typeof value === 'string') return `${key} = '${value}'`
      return `${key} = ${value}`
    })
    .join(' AND ')
}

export const parseLike = (like?: likeProps) => {
  if (!like) return ''
  Object.entries(like)
    .map(([key, value]) => {
      return `${key} LIKE '%${value}%'`
    })
    .join(' AND ')
}

export function queryBuilder({
  select,
  join,
  like,
  limit = 10,
  tableName = TABLE_NAME.default,
  where
}: QueryBuilderProps) {
  const whereQuery = parseWhere(where)
  const likeQuery = parseLike(like)
  const selectQuery = select ? select.join(', ') : '*'

  return `SELECT ${selectQuery}
    FROM \`${DB_NAME}.${tableName}\`
    ${join ? `JOIN ${DB_NAME}.${join.tableName} ON ${join.on}` : ''}
    ${where ? `WHERE ${whereQuery}` : ''}
    ${like ? `LIKE ${likeQuery}` : ''} 
    LIMIT ${limit}`
}
