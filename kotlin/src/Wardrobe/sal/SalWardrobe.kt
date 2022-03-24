package wardrobe.sal

typealias Width = Int
typealias Price = Int

fun combinations(
    goal: Width = 250,
    availableSizes: List<Width> = listOf(50, 75, 100, 120)
): Set<List<Width>> =
    if (goal == 0)
        setOf(emptyList())
    else
        availableSizes
            .filter { it <= goal }
            .flatMap { width ->
                val rest = goal - width
                val partial = combinations(rest, availableSizes)
                partial.map { it + width }
            }
            .map { it.sorted() }
            .toSet()

fun Collection<List<Width>>.cheapest(
    costs: Map<Width, Price>
): Pair<List<Width>, Price> =
    map { it to (it priced costs) }
        .minByOrNull { (_, cost) -> cost }!!

private infix fun List<Width>.priced(costs: Map<Width, Price>) =
    sumOf { costs[it] ?: throw IllegalArgumentException("Invalid cost $it") }

fun main() {
    val ikea = combinations()
    ikea
        .toList()
        .sortedByDescending { it.maxOf { list -> list } }
        .sortedByDescending { it.size }
        .forEachIndexed { i, list ->
            println("#${(i + 1).toString().padStart(3)}: $list")
        }

    val costs = mapOf(50 to 59, 75 to 62, 100 to 90, 120 to 111)
    val (best, price) = ikea.cheapest(costs)

    println("The cheapest combinations costs $price USD: $best")
}
