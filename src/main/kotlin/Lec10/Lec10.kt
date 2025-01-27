package Lec10

fun main() {
    Derived(200)
}

open class Base(
    open val number: Int = 100  // not recommend open keyword
) {

    init {
        println("Base Class")
        println(number) // because of this
    }
}

class Derived(
    override val number: Int
) : Base(number) {

    init {
        println("Derived Class")
    }
}
