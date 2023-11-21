import React from 'react'
import { Loader } from '../icons/Loader'
import { cn } from '@/lib/utils'

export interface ButtonProps
  extends React.ButtonHTMLAttributes<HTMLButtonElement> {
  href?: string
  isLoading?: boolean
}

type AnchorProps = React.AnchorHTMLAttributes<HTMLAnchorElement>
type CustomProps = ButtonProps & AnchorProps

const Button = React.forwardRef<
  HTMLButtonElement,
  CustomProps
>(({ className, isLoading, disabled, children, href, ...props }, ref) => {
  if (href) {
    return (
      <a
        ref={ref as React.Ref<HTMLAnchorElement>}
        className={cn(
          'flex-row gap-x-3 inline-flex items-center text-xl font-medium rounded-xl shadow-sm border-transparent ring-1 ring-transparent py-3 px-11 justify-center text-white bg-blue-500 whitespace-nowrap cursor-pointer hover:bg-blue-600 focus:ring-4 focus:outline-none focus:ring-[#1da1f2]/50 text-center transition-color',
          className
        )}
        href={href}
        {...props}
      >
        {children}
      </a>
    )
  }

  return (
    <button
      className={cn(
        'flex-row gap-x-3 inline-flex items-center text-xl font-medium rounded-xl shadow-sm border-transparent ring-1 ring-transparent py-3 px-11 justify-center text-white bg-blue-500 whitespace-nowrap cursor-pointer hover:bg-blue-600 focus:ring-4 focus:outline-none focus:ring-[#1da1f2]/50 text-center transition-color',
        className
      )}
      disabled={disabled || isLoading}
      ref={ref as React.Ref<HTMLButtonElement>}
      {...props}
    >
      {isLoading ? <Loader className="mr-2" /> : children}
    </button>
  )
})

export default Button
