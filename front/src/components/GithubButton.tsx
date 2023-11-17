import GithubIcon from '../icons/GithubIcon.tsx'

export default function GithubButton({
  children
}: { children?: React.ReactNode }) {
  return (
    <a
      href="https://github.com/RABrL/TechPlus-Test2"
      target="_blank"
      rel="noreferrer"
      title="Go to GitHub Repository"
      className="inline-flex flex-shrink-0 py-2 text-base font-medium group
          md:text-lg transition-all text-slate-500 hover:text-slate-700"
    >
      <div className="flex items-center space-x-1">
        <GithubIcon />
        {children}
      </div>
    </a>
  )
}
