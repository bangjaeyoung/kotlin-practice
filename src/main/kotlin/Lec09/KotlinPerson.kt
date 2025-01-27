package Lec09

fun main() {
    val person = Person("developer", 100)
    println(person.name)
    person.age = 10
    println(person.age)

    val javaPerson = JavaPerson("developer2", 200)
    println(javaPerson.name)
    javaPerson.age = 50
    println(javaPerson.age)

    val person2 = Person("developer")
    println(person2.name)
    person.age = 10
    println(person2.age)

    val student = Student()

    val person3 = Person()
    println(person3.name)
    println(person3.age)

    val person4 = Person()

    println(person3.upperCaseName2)
    person3.name = "jae"
    println(person3.name)
}

class Person(
    // 주생성자
    // recommend default parameter
    name: String = "young",
    var age: Int = 20
) {

    var name = name
        set(value) {
            field = value.uppercase()
        }

//    fun getUpperCaseName(): String = this.name.uppercase()

    val upperCaseName: String
        get() = this.name.uppercase()

    val upperCaseName2: String
        get() {
            return this.name.uppercase()
        }

    // use Backing Field (avoid Infinite Loop)
    // required removing 'val' keyword for using this
//    val name = name
//        get() {
//            return field.uppercase()
//        }

    init {
        if (age <= 0) {
            throw IllegalArgumentException(String.format("나이는 ${age}일 수 없습니다."))
        }
        println("초기화 블록")
    }

//    constructor(name: String) : this(name, 1) {
//        println("1번째 부생성자")
//    }
//
//    constructor() : this("bang") {
//        println("2번째 부생성자")
//    }

    // 1. function
    fun isAdult(): Boolean {
        return this.age >= 20
    }

    // 2. Custom Getter like property
    val isAdult1: Boolean
        get() = this.age >= 20

    // 3. Custom Getter like property by expression
    val isAdult2: Boolean
        get() {
            return this.age >= 20
        }
}

class Student