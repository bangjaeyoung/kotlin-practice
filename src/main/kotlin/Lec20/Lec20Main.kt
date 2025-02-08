package Lec20

import Lec19.Person

/**
 * scope function: 일시적인 영역을 형성하는 함수
 * - 람다를 사용해 일시적인 영역을 만들고 코드를 더 간결하게 만들거나, method chaining에 활용
 */
fun main() {
    val person = Person("bang", 10)
    printPerson(person)
    printPersonScopeFunction(person)

    /**
     * scope function
     * - let, run, also, apply(확장함수 o)
     * - with(확장함수 x)
     */

    // age 반환, it 사용
    val value1 = person.let {
        it.age
    }

    // age 반환, this 사용
    val value2 = person.run {
        this.age
    }

    // Person 객체 반환, it 사용
    val value3 = person.also {
        it.age
    }

    // Person 객체 반환, this 사용
    val value4 = person.apply {
        this.age
    }

    println(value1)
    println(value2)
    println(value3)
    println(value4)

    // with(파라미터, 람다)
    with(person) {
        println(name)
        println(this.age)
    }
}

fun printPerson(person: Person?) {
    if (person != null) {
        println(person.name)
        println(person.age)
    }
}

fun printPersonScopeFunction(person: Person?) {
    person?.let {
        println(it.name)
        println(it.age)
    }
}
