export default async function getExpenses(month: number, year: number) {
  // TODO remove hardcoded user
  const resp = await fetch(`${process.env.REACT_APP_EXPENSES_API_URL}/25?month=${month}&year=${year}`)
  if (!resp.ok) {
    throw new Error('Error retrieving expenses')
  }
  return resp.json()
}
