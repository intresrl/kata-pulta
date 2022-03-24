package ticTacToe.orn

enum class State {
    X, O, EMPTY;
}

fun getPlayer() =
    if(Math.random()>0.5) State.X
    else State.O
