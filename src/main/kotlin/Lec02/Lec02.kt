package Lec02

fun main() {
    val str: String? = null
    println(str?.length ?: 0)

    println(startsWithA4("ABC"))
    println(startsWithA4(null))
}

fun startsWithA1(str: String?): Boolean {
    return str?.startsWith("A")
        ?: throw IllegalArgumentException("null이 들어왔습니다.")
}

fun startsWithA2(str: String?): Boolean? {
    return str?.startsWith("A")
}

fun startsWithA3(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}

fun startsWithA4(str: String?): Boolean {
    return str!!.startsWith("A")
}
