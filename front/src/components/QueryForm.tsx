import { useState } from 'react'
import { zodResolver } from '@hookform/resolvers/zod'
import { useForm } from 'react-hook-form'

import {
  Form,
  FormField,
  FormItem,
  FormLabel,
  FormControl,
  FormMessage
} from '@/components/ui/form'
import Button from '@/components/Button'
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue
} from '@/components/ui/select'
import { Checkbox } from '@/components/ui/checkbox'
import { Slider } from '@/components/ui/slider'

import { TABLE_NAME } from '@/lib/definitions'
import { type TQueryFormSchema, queryFormSchema } from '@/lib/schemas'
import type { QueryBuilderProps, selectProps, whereProps } from '@/lib/types'
import { fetchQuery } from '@/services/fetchQuery'

export default function QueryForm() {
  const form = useForm<TQueryFormSchema>({
    resolver: zodResolver(queryFormSchema),
    defaultValues: {
      Abnormal_Conditions_Checked_YN: false,
      Ave_Age_of_Mother: [30, 40],
      Ave_Birth_Weight_gms: [3010, 3100],
      County_of_Residence: '',
      Mothers_Single_Race: '',
      Year: '',
      select: []
    }
  })

  async function onSubmit({
    Ave_Age_of_Mother,
    Ave_Birth_Weight_gms,
    Abnormal_Conditions_Checked_YN,
    County_of_Residence,
    Mothers_Single_Race,
    Year,
    select
  }: TQueryFormSchema) {
    const where: whereProps = {}
    const query: QueryBuilderProps = {}
    if (Year) where.Year = Year

    if (County_of_Residence) where.County_of_Residence = County_of_Residence

    if (Abnormal_Conditions_Checked_YN) {
      query.tableName = TABLE_NAME.abnormal_conditions
      where.Abnormal_Conditions_Checked_YN = 1
    }
    console.log(Ave_Age_of_Mother)
    if (Mothers_Single_Race) where.Mothers_Single_Race = Mothers_Single_Race
    console.log(Ave_Age_of_Mother)
    query.where = Object.keys(where).length > 0 ? where : undefined

    if (select?.length != null && select?.length > 0)
      query.select = select as selectProps[]

    const data = await fetchQuery(query)
    console.log(data)
  }
  return (
    <Form {...form}>
      <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-8">
        <FormField
          control={form.control}
          name="Year"
          render={({ field }) => (
            <FormItem>
              <FormLabel>
                Select one year to filter{' '}
                <span className="text-xs text-zinc-600">(default=none)</span>
              </FormLabel>
              <FormControl>
                <Select
                  onValueChange={field.onChange}
                  defaultValue={field.value}
                >
                  <FormControl>
                    <SelectTrigger>
                      <SelectValue placeholder="Select a year" />
                    </SelectTrigger>
                  </FormControl>
                  <SelectContent>
                    {['2016', '2017', '2018'].map((item) => (
                      <SelectItem key={item} value={`${item}-01-01`}>
                        {item}
                      </SelectItem>
                    ))}
                  </SelectContent>
                </Select>
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />
        <FormField
          control={form.control}
          name="County_of_Residence"
          render={({ field }) => (
            <FormItem>
              <FormLabel>
                Select one county of residence{' '}
                <span className="text-xs text-zinc-600">(default=none)</span>
              </FormLabel>
              <FormControl>
                <Select
                  onValueChange={field.onChange}
                  defaultValue={field.value}
                >
                  <FormControl>
                    <SelectTrigger>
                      <SelectValue placeholder="Select a county" />
                    </SelectTrigger>
                  </FormControl>
                  <SelectContent>
                    {['2016', '2017', '2018'].map((item) => (
                      <SelectItem key={item} value={`${item}-01-01`}>
                        {item}
                      </SelectItem>
                    ))}
                  </SelectContent>
                </Select>
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />
        <FormField
          control={form.control}
          name="Abnormal_Conditions_Checked_YN"
          render={({ field }) => (
            <FormItem className="flex flex-row items-start space-x-3 space-y-0 rounded-md border p-4">
              <FormControl>
                <Checkbox
                  checked={field.value}
                  onCheckedChange={field.onChange}
                />
              </FormControl>
              <div className="space-y-1 leading-none">
                <FormLabel className="cursor-pointer">
                  Abnormal conditions{' '}
                </FormLabel>
              </div>
            </FormItem>
          )}
        />
        <FormField
          control={form.control}
          name="Ave_Birth_Weight_gms"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Average weight of birth (GRAMS)</FormLabel>
              <FormControl>
                <Slider
                  value={field.value}
                  min={3000}
                  max={3400}
                  step={0.1}
                  onValueChange={field.onChange}
                  minStepsBetweenThumbs={20}
                />
              </FormControl>
              <FormMessage />
              <p>{field.value[0]}</p>
            </FormItem>
          )}
        />
        <FormField
          control={form.control}
          name="Ave_Age_of_Mother"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Average age of mother (YEARS)</FormLabel>
              <FormControl>
                <Slider
                  value={field.value}
                  aria-label="Average age of mother (YEARS)"
                  step={0.01}
                  min={15}
                  max={80}
                  onValueChange={field.onChange}
                />
              </FormControl>
              <FormMessage />
              <p>{field.value[0]}</p>
            </FormItem>
          )}
        />
        <Button type="submit" className="">
          Run Query
        </Button>
      </form>
    </Form>
  )
}
