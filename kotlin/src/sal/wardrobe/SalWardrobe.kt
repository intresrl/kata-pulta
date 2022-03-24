package sal.wardrobe

typealias Width = Int

val elementSizes: List<Width> = listOf(50, 75, 100, 120)

const val goalSize: Width = 250

fun combinations(
    goal: Width = goalSize,
    availableSizes: List<Width> = elementSizes
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
            .toSet()


fun main() {
    val ikea = combinations()
    ikea
        .toList()
        .sortedByDescending { it.maxOf { list -> list } }
        .sortedByDescending { it.size }
        .forEachIndexed { i, list ->
            println("#${(i + 1).toString().padStart(3)}: $list")
        }
}
