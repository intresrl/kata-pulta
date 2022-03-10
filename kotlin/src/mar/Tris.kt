package mar

import java.util.*


class Tris {
    private var next = 'O'
    private val game: MutableList<Char> = ArrayList(Collections.nCopies(9, ' '))

    fun size() = game.size

    fun play(x:Int, y:Int) {
        val position = x+(y*3)

        if(game[position] != ' ') {
            throw java.lang.Error()
        }
        game[position] = next

        setNext()
    }

    fun print() = game.joinToString("")

    private fun setNext() {
        next = if(next == 'O') {
            'X'
        } else {
            'O'
        }
    }
}
