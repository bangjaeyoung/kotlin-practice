import Lec08.Lec08

fun main() {
    repeat("Hello", 3, true)
    repeat("Hi")
    repeat("Bye", useNewLine = false)

    printNameAndGender(name = "developer", gender = "MALE")

    val arr = arrayOf("A", "B", "C")
    printAll(*arr)
    printAll("D", "E", "F")
}

fun max(a: Int, b: Int) = if (a > b) a else b

fun repeat(
    str: String,
    num: Int = 3,
    useNewLine: Boolean = true
) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

fun printNameAndGender(name: String, gender: String) {
    println(name)
    println(gender)
}

fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}
