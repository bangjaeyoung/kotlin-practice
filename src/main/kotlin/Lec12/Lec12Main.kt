package Lec12

fun main() {
    moveSomething(object : Movable {
        override fun move() {
            println("move move!")
        }

        override fun fly() {
            println("fly fly!")
        }
    })
}

private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}
