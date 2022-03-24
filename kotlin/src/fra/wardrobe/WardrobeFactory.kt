package fra.wardrobe


class WardrobeFactory {

    companion object {
        fun getPossibleCombos(elements: ArrayList<Int>, wallLength: Int): ArrayList<ArrayList<Int>> {
            elements.sort()

            val combo: ArrayList<Int> = arrayListOf()
            val result: ArrayList<ArrayList<Int>> = arrayListOf()
            findCombos(0, 0, wallLength, elements, combo, combos = result )
            return result
        }
        private fun findCombos(
            start: Int, sum: Int, target: Int,
            elements: ArrayList<Int>,
            combo: ArrayList<Int>,
            combos: ArrayList<ArrayList<Int>>
        ) {
            if (sum == target) {
                combos.add(combo)
                return
            }

            for (i in start until elements.size) {

                if (sum + elements[i] > target ||
                i > start && elements[i] == elements[i - 1]) continue

                combo.add(elements[i])

                findCombos(
                    i + 1, sum + elements[i], target, elements,
                    combo, combos
                )

                combo.remove(combo.size - 1)
            }
        }
    }
}