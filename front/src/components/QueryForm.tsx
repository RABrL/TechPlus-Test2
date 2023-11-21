import {
  Form,
  FormField,
  FormItem,
  FormLabel,
  FormControl,
  FormMessage
} from '@/components/ui/form'
import { zodResolver } from '@hookform/resolvers/zod'
import { useForm } from 'react-hook-form'
import { z } from 'zod'
import Button from '@/components/Button'
import SelectReact from 'react-select'
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue
} from '@/components/ui/select'
import { Checkbox } from './ui/checkbox'
import { Slider } from '@/components/ui/slider'
import {
  fetchQuery,
  TABLE_NAME,
  type QueryBuilderProps,
  type selectProps,
  type whereProps
} from '@/services/queryBuilder'

const formSchema = z
  .object({
    Year: z.string(),
    County_of_Residence: z.string(),
    Ave_Age_of_Mother: z.array(z.number().min(15).max(100)),
    Ave_Birth_Weight_gms: z.array(z.number().min(3000).max(3400)),
    Mothers_Single_Race: z.string(),
    Abnormal_Conditions_Checked_YN: z.boolean(),
    select: z.array(z.string())
  })
  .partial()
  .required({ Ave_Age_of_Mother: true, Ave_Birth_Weight_gms: true })
const selectOptions = [
  { value: 'Abnormal_Conditions_Checked_YN', label: 'Abnormal conditions' },
  { value: 'Ave_Age_of_Mother', label: 'Average age of mother' },
  { value: 'Ave_Birth_Weight_gms', label: 'Average weight of birth' },
  { value: 'County_of_Residence', label: 'County of residence' },
  { value: 'Year', label: 'Year' },
  { value: 'Births', label: 'Births' },
  { value: '*', label: 'All fields' }
]

export default function QueryForm() {
  const form = useForm<z.infer<typeof formSchema>>({
    resolver: zodResolver(formSchema),
    defaultValues: {
      Abnormal_Conditions_Checked_YN: false,
      Ave_Age_of_Mother: [15],
      Ave_Birth_Weight_gms: [3000],
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
  }: z.infer<typeof formSchema>) {
    const where: whereProps = {}
    const query: QueryBuilderProps = {}
    if (Year) where.Year = Year

    if (County_of_Residence) where.County_of_Residence = County_of_Residence

    if (Abnormal_Conditions_Checked_YN) {
      query.tableName = TABLE_NAME.abnormal_conditions
      where.Abnormal_Conditions_Checked_YN = 1
    }

    if (Ave_Age_of_Mother[0] !== 15)
      where.Ave_Age_of_Mother = Ave_Age_of_Mother[0]

    if (Ave_Birth_Weight_gms[0] !== 3000)
      where.Ave_Birth_Weight_gms = Ave_Birth_Weight_gms[0]

    if (Mothers_Single_Race) where.Mothers_Single_Race = Mothers_Single_Race

    query.where = where
    if (select?.length != null && select?.length > 0)
      query.select = select as selectProps[]

    const res = await fetchQuery(query)

    console.log(res)
  }
  return (
    <Form {...form}>
      <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-8">
        <FormField
          control={form.control}
          name="select"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Choose the fields to search</FormLabel>
              <FormControl>
                <SelectReact
                  defaultValue={[]}
                  isMulti
                  name="select"
                  options={selectOptions}
                  className="basic-multi-select"
                  classNamePrefix="select"
                  placeholder="Select a field..."
                />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />
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
                  defaultValue={[field.value[0]]}
                  max={3400}
                  min={3000}
                  onValueChange={field.onChange}
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
                  defaultValue={[field.value[0]]}
                  onValueChange={field.onChange}
                />
              </FormControl>
              <FormMessage />
              <p>{field.value[0]}</p>
            </FormItem>
          )}
        />
        <Button type="submit">Submit</Button>
      </form>
    </Form>
  )
}
