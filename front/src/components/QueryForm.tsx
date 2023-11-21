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
import { z } from 'astro/zod'
import Button from '@/components/Button'
const formSchema = z.object({
  username: z.string().min(2, {
    message: 'Username must be at least 2 characters.'
  })
})
const form = useForm<z.infer<typeof formSchema>>({
  resolver: zodResolver(formSchema),
  defaultValues: {
    username: ''
  }
})
function onSubmit(values: z.infer<typeof formSchema>) {
  // Do something with the form values.
  // ✅ This will be type-safe and validated.
  console.log(values)
}

export default function QueryForm() {
  return (
    <Form {...form}>
      <form onSubmit={form.handleSubmit(onSubmit)}>
        <FormField
          control={form.control}
          name="username"
          render={({ field }) => {
            ;<FormItem>
              <FormLabel>Username</FormLabel>
              <FormControl>
                <input placeholder="shadcn" {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          }}
        />
        <Button type="submit">Submit</Button>
      </form>
    </Form>
  )
}
