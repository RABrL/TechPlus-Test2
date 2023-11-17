import { Popover } from '@headlessui/react'
import { Bars3Icon, XMarkIcon } from '@heroicons/react/24/outline'

export default function BurgerMenu() {
  return (
    <Popover className="ml-4">
      <Popover.Button className="bg-slate-100 rounded-md p-2 text-slate-400 hover:text-slate-500">
        <span className="sr-only">Open menu</span>
        <Bars3Icon className="h-6 w-6 " />
      </Popover.Button>
      <Popover.Overlay className="fixed inset-0 bg-slate-800/30" />
      <Popover.Panel className="fixed inset-x-0 top-0 z-50 m-1 opacity-100 scale-100">
        <div className="rounded-xl shadow-lg  bg-white m-2">
          <header className="flex justify-between items-center py-3 px-5">
            <div className="flex justify-start lg:w-1/4">
              <a href="/">
                <img src="/logo.png" alt="Tech+ logo" width="80" />
              </a>
            </div>
            <Popover.Button
              className="bg-slate-100 rounded-md p-2 text-slate-400 hover:text-slate-500 hover:bg-slate-100"
              type="button"
            >
              <span className="sr-only">Close menu</span>
              <XMarkIcon className="h-6 w-6" />
            </Popover.Button>
          </header>
          <nav className="py-3 px-5 text-lg text-slate-800 font-medium">
            <a
              href="/builder"
              className="hover:bg-slate-100 flex items-center w-full h-14 transition-colors rounded-lg"
            >
              Builder
            </a>
            <a
              href="/community"
              className="hover:bg-slate-100 flex items-center w-full h-14 transition-colors rounded-lg"
            >
              Community queries
            </a>
            <a
              href="/about"
              className="hover:bg-slate-100 flex items-center w-full h-14 transition-colors rounded-lg"
            >
              About
            </a>
          </nav>
          <footer className="flex text-center px-5 rounded-b-xl bg-slate-50 py-4 space-x-6">
            <a
              href="https://github.com/RABrL/TechPlus-Test2"
              target="_blank"
              rel="noreferrer"
              title="Go to GitHub Repository"
              className="inline-flex flex-shrink-0 py-2 text-base font-medium group
                  md:text-lg transition-all text-slate-500 hover:text-slate-700"
            >
              <div className="flex items-center space-x-1">
                <svg
                  className="h-6 w-6 transform"
                  fill="none"
                  viewBox="0 0 24 24"
                >
                  <path
                    fillRule="evenodd"
                    clipRule="evenodd"
                    d="M12 2C6.477 2 2 6.463 2 11.97c0 4.404 2.865 8.14 6.839 9.458.5.092.682-.216.682-.48 0-.236-.008-.864-.013-1.695-2.782.602-3.369-1.337-3.369-1.337-.454-1.151-1.11-1.458-1.11-1.458-.908-.618.069-.606.069-.606 1.003.07 1.531 1.027 1.531 1.027.892 1.524 2.341 1.084 2.91.828.092-.643.35-1.083.636-1.332-2.22-.251-4.555-1.107-4.555-4.927 0-1.088.39-1.979 1.029-2.675-.103-.252-.446-1.266.098-2.638 0 0 .84-.268 2.75 1.022A9.606 9.606 0 0112 6.82c.85.004 1.705.114 2.504.336 1.909-1.29 2.747-1.022 2.747-1.022.546 1.372.202 2.386.1 2.638.64.696 1.028 1.587 1.028 2.675 0 3.83-2.339 4.673-4.566 4.92.359.307.678.915.678 1.846 0 1.332-.012 2.407-.012 2.734 0 .267.18.577.688.48C19.137 20.107 22 16.373 22 11.969 22 6.463 17.522 2 12 2z"
                    fill="currentColor"
                  ></path>
                </svg>
                <p className="ml-w">Github</p>
              </div>
            </a>
          </footer>
        </div>
      </Popover.Panel>
    </Popover>
  )
}
