enum class State {
    X{
     override fun nextPlayer() = O
     }, O, EMPTY;

    open fun nextPlayer(): State {
        return X;
    }
}

fun getPlayer() =
    if(Math.random()>0.5) State.X
    else State.O
