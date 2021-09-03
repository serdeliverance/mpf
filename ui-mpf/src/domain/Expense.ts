export default interface Expense {
    id: number,
    name: string,
    description?: string,
    provider: string,
    date: Date,
    category: string,
    subcategories: string[],
    amount: number
}
