package Lec19

import Lec18.Fruit

// as import 같은 이름의 함수를 한 파일 내에서 동시에 import 할 수 있음
import Lec19.a.printHello as printHelloA
import Lec19.b.printHello as printHelloB


data class Person(
    val name: String,
    val age: Int,
)

// data class가 아닌 경우에 componentN 함수가 없으므로 구조분해를 사용하기 위해서는 직접 구현해야 함
class Person2(
    val name: String,
    val age: Int,
) {
    operator fun component1(): String {
        return this.name
    }

    operator fun component2(): Int {
        return this.age
    }
}

fun main() {
    /**
     * as Import
     */
    printHelloA()
    printHelloB()

    /**
     * 구조 분해, componentN 함수
     */
    val person = Person("bang", 1000)
    val (name, age) = person
//    val name = person.component1()
//    val age = person.component2()
    println(name)
    println(age)

    val person2 = Person2("jae", 2000)
    val (name2, age2) = person2
    println(name2)
    println(age2)

    /**
     * return: 기본적으로 가장 가까운 enclosing function 또는 익명함수로 값이 반환됨
     * break: 가장 가까운 루프가 제거
     * continue: 가장 가까운 루프를 다음 step으로 보냄
     */
    val numbers = listOf(1, 2, 3)
    for (number in numbers) {
        if (number == 2) {
            println(number)
            break   // break, continue 사용 가능
        }
    }

    // forEach의 경우 break, continue 사용 불가
    numbers.forEach { number ->
        println(number)
        if (number == 2) {
            println(number)
        }
    }

    // run 구문 안에 작성하고
    // break의 경우 return@run으로 대체 가능
    // continue의 경우 return@forEach로 대체 가능
    run {
        numbers.forEach { number ->
            println(number)
            if (number == 2) {
                println(number)
                return@run
            }
        }
    }

    /**
     * Label 사용 - Java의 Loop: 와 비슷함
     * 사용하지 않는 것을 추천 - 코드 복잡도 증가, 유지보수 힘듦
     */
    loop@ for (i in 1..100) {
        for (j in 1..10) {
            if (j == 2) {
                break@loop
            }
            println("${i}, ${j}")
        }
    }
}


// Type Alias
typealias FilterFruit = (Fruit) -> Boolean

fun filterFruits(fruits: List<Fruit>, filter: FilterFruit) {

}

data class UltraSuperGuardianTribe(
    val name: String
)

typealias USGTMap = Map<String, UltraSuperGuardianTribe>

/**
 * TakeIf: 주어진 조건을 만족하면 그 값이, 그렇지 않으면 null 반환
 * TakeUnless: 주어진 조건을 만족하지 않으면 그 값이, 그렇지 않으면 null 반환
 */
var number = 3

fun getNumberOrNullV1(): Int? {
    return number.takeIf { number -> number > 0 }
//    return number.takeIf { it > 0 }
}

fun getNumberOrNullV2(): Int? {
    return number.takeUnless { number -> number <= 0 }
//    return number.takeIf { it > 0 }
}