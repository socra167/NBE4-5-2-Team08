import Link from "next/link";
import Image from "next/image";
import { Search } from "lucide-react";

export default function Header() {
  return (
    <header className="border-b">
      <div className="container flex h-14 items-center px-4">
        <div className="flex items-center space-x-4">
          <Link href="/" className="flex items-center space-x-2">
            <Image
              src="/placeholder.svg?height=32&width=32"
              alt="Logo"
              width={32}
              height={32}
              className="rounded"
            />
          </Link>
          <nav className="flex items-center space-x-4 text-sm font-medium">
            <Link
              href="/활동외"
              className="transition-colors hover:text-gray-600"
            >
              활동외
            </Link>
            <Link
              href="/북마크"
              className="transition-colors hover:text-gray-600"
            >
              북마크
            </Link>
          </nav>
        </div>
        <div className="ml-auto flex items-center space-x-4">
          <div className="relative">
            <Search className="absolute left-2.5 top-2.5 h-4 w-4 text-gray-500" />
            <input
              type="search"
              placeholder="인사이트 검색..."
              className="h-9 w-[300px] rounded-md border bg-white pl-8 pr-3 text-sm"
            />
          </div>
          <button className="inline-flex h-9 items-center justify-center rounded-md bg-black px-3 text-sm font-medium text-white shadow hover:bg-gray-800">
            새 글쓰기
          </button>
          <div className="relative">
            <button className="flex h-8 w-8 items-center justify-center rounded-full bg-gray-200">
              <Image
                src="/placeholder.svg?height=32&width=32"
                alt="Avatar"
                width={32}
                height={32}
                className="rounded-full"
              />
            </button>
          </div>
        </div>
      </div>
    </header>
  );
}
