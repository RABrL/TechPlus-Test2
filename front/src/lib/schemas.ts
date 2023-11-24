import { z } from "zod";

export const queryFormSchema = z
  .object({
    Year: z.string(),
    County_of_Residence: z.string(),
    Ave_Age_of_Mother: z.tuple([z.number().min(15), z.number().max(80)]),
    Ave_Birth_Weight_gms: z.tuple([z.number().min(3000), z.number().max(3400)]),
    Mothers_Single_Race: z.string(),
    Abnormal_Conditions_Checked_YN: z.boolean(),
    select: z.array(z.string())
  })
  .partial()
  .required({ Ave_Age_of_Mother: true, Ave_Birth_Weight_gms: true })

export type TQueryFormSchema = z.infer<typeof queryFormSchema>