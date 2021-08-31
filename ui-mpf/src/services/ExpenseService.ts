export default async function getExpenses(month: number, year: number) {
  // TODO remove hardcoded user
  const resp = await fetch(`${process.env.EXPENSES_API_URL}/25?${month}=month&year=${year}`)
  if (!resp.ok) {
    throw new Error('Error retrieving expenses')
  }
  return resp.json()
}
