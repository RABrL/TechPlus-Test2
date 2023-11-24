import type { QueryBuilderProps } from "@/lib/types"

export const fetchQuery = async (query: QueryBuilderProps) => {
  return fetch('/api/query.json', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(query)
  })
    .then((res) => {
      if (!res.ok) {
        console.log(res.statusText)
      }
      return res.json()
    })
    .then((data) => {
      return data
    })
}
