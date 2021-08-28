interface Expense {
  id: number,
  amount: number,
  description?: string,
  name: string
  provider: string,
  date: Date,
  category: string,
  subcategories: Array<string>
}