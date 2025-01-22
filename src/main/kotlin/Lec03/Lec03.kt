import Lec02.Person

fun main() {
    val number1 = 3L
    val number2: Int = number1.toInt()

    val number3 = 3
    val number4 = 6
    val result = number4 / number3.toDouble()
    println(result)

    val number5: Int? = null
    val number6 = number5?.toDouble() ?: 6
    println(number6)

    val person = Person("dev", 10)
    println("name: ${person.name}")

    val name = "developer"
    println("name: $name")

    val str = """
        ABC
        DEF
        ${name}
    """.trimIndent()
    println(str)

    println(str[4])
}

fun printAgeIfPerson(obj: Any?) {
    val person = obj as? Person
    println(person?.age)
}