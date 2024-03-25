export interface iRoot {
  posts: iPost[]
  total: number
  skip: number
  limit: number
}

export interface iPost {
  id: number
  title: string
  body: string
  userId: number
  tags: string[]
  active: boolean
}
