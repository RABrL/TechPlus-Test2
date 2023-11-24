export const DB_NAME = 'bigquery-public-data.sdoh_cdc_wonder_natality'

export enum TABLE_NAME {
  abnormal_conditions = 'county_natality_by_abnormal_conditions',
  default = 'county_natality'
}

export const SELECT_OPTIONS = [
  { value: 'Abnormal_Conditions_Checked_YN', label: 'Abnormal conditions' },
  { value: 'Ave_Age_of_Mother', label: 'Average age of mother' },
  { value: 'Ave_Birth_Weight_gms', label: 'Average weight of birth' },
  { value: 'County_of_Residence', label: 'County of residence' },
  { value: 'Year', label: 'Year' },
  { value: 'Births', label: 'Births' },
  { value: '*', label: 'All fields' }
]