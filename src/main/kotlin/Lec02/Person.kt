import Lec02.Person

fun main() {
    val person = Person("developer")
    println(startsWith(person.name))
}

fun startsWith(str: String): Boolean {
    return str.startsWith("A")
}
