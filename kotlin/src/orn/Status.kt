package orn

enum class Status {
    PLAYING, X_WON{
        override fun message() {
            println("X wins this game")
        }
    }, O_WON {
        override fun message() {
            println("Y wins this game")
        }
    }, DRAW {
        override fun message() {
            println("No winners today,sad day")
        }
    };

    open fun message() {
        println("The game is still in progress")
    }
}
