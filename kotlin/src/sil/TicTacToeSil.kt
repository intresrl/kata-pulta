package sil

import mob.State

import kotlin.random.Random

class FreeSpace{
    var x: Int = 0
    var y: Int = 0
}
class Board {
    val grid = MutableList(3) {
        MutableList(3) {
            State.EMPTY
        }
    }

    fun getFirstPlayer(): State{
        var aux= Random.nextInt(0,1);
        if(aux==0) return State.X
        else return State.O
    }

    fun getFreeSpaces(): IntArray {
        var freeSpaces: MutableList<FreeSpace> = ArrayList()
        var aux = grid.flatten()
        aux.forEachIndexed { index, x ->
            if (x === mob.State.EMPTY)
                freeSpaces.add()
        }
    }
}
