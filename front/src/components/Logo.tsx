export default function Logo({
  width = 80,
  href = '/'
}: { width?: number; href?: string }) {
  return (
    <a href={href}>
      <img src="/logo.png" alt="Tech+ logo" width={width} />
    </a>
  )
}
