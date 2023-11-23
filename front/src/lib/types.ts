import type { TABLE_NAME } from "./definitions"

export interface whereProps {
  Abnormal_Conditions_Checked_YN?: 0 | 1
  Ave_Age_of_Mother?: number
  Ave_Birth_Weight_gms?: number
  County_of_Residence?: string
  Mothers_Single_Race?: string
  Year?: string
}

export interface likeProps {
  County_of_Residence?: string
  Mothers_Single_Race?: string
}

export type selectProps = keyof whereProps | '*' | 'Births'

export interface QueryBuilderProps {
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
