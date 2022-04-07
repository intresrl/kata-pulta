package wordChain.sal

import java.io.File

fun main() {
    val dict: Map<Int, List<String>> = File("java/word-chain/dictionary")
        .readLines()
        .groupBy { it.length }

    fun String.distance(s: String) =
        when (length) {
            s.length -> zip(s).count { (a, b) -> a != b }
            else -> Int.MAX_VALUE
        }

    fun chain(first: String, last: String): List<String> {
        var words = dict[first.length] ?: throw IllegalStateException("No words of valid length")

        val successors = mutableMapOf<String, List<String>>()

        var currentList = listOf(first)
        while (last in words) {
            currentList = currentList.flatMap { start ->
                val next = words.filter { word -> word.distance(start) == 1 }
                successors[start] = next
                next
            }
            words = words - currentList.toSet()
        }

        val result = mutableListOf<String>()
        var word: String? = last
        while (word != null) {
            result += word
            word = successors.firstNotNullOfOrNull { (k, v) -> if (word in v) k else null }
        }
        return (result+first).reversed()
    }

    println(chain("pig", "sty"))
    println(chain("four", "five"))
    println(chain("wheat", "bread"))
    println(chain("pen", "ink"))
    println(chain("nose", "chin"))
    println(chain("tears", "smile"))
}
