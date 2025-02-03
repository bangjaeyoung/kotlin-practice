package Lec16

fun main() {
    val str = "ABC"
    println(str.lastChar())



    val person = JavaPerson("A", "B", 100)
    // 확장 함수보다 클래스 안의 멤버 함수를 우선 호출 (두 함수의 시그니처가 같을 경우)
    person.nextYearAge()



    // 해당 변수의 현재 타입 즉, 정적인 타입에 의해 어떤 확장 함수가 호출될지 결정됨
    val train: Train = Train()
    train.isExpensive() // Train의 확장 함수 호출

    val srt1: Train = Train()
    srt1.isExpensive() // Train의 확장 함수 호출

    val srt2: Srt = Srt()
    srt2.isExpensive() // Srt의 확장 함수 호출



    println(3.add(4))
    println(3.add2(4))
    // 중위 함수 호출 방법
    println(3 add2 4)



    // inline 함수 호출
    println(3.add3(4))
}

/**
 * 확장 함수: 어떤 클래스 안에 있는 메소드처럼 호출할 수 있지만, 클래스 밖에 만들어진 함수 (Java와 Kotlin의 100% 호환성을 위해 생긴 개념)
 * 확장 함수는 클래스에 있는 private 또는 protected 멤버를 가져올 수 없음 (캡슐화를 깨지 않음)
 * fun 확장하려는클래스.함수이름(파라미터): 리턴타입 {
 *   // this를 이용해 실제 클래스 안의 값에 접근
 * }
 *
 * String 클래스의 확장 함수
 * 클래스 밖의 함수는 바이트 코드 변환 및 디컴파일 시, static 함수로 선언되어 있음
 */
fun String.lastChar(): Char {
    return this[this.length - 1]
}

// 확장 프로퍼티 (확장 함수 + custom getter)
val String.lastChar: Char
    get() = this[this.length - 1]



fun JavaPerson.nextYearAge(): Int {
    println("확장 함수")
    return this.age + 1
}



open class Train(
    val name: String = "새마을기차",
    val price: Int = 5_000,
)

fun Train.isExpensive(): Boolean {
    println("Train의 확장 함수")
    return this.price >= 10_000
}

class Srt : Train("SRT", 40_000)

fun Srt.isExpensive(): Boolean {
    println("Srt의 확장 함수")
    return this.price >= 20_000
}



fun Int.add(other: Int): Int {
    return this + other
}

// 중위(Infix) 함수
infix fun Int.add2(other: Int): Int {
    return this + other
}



/**
 * inline 함수: 함수가 호출되는 대신, 함수를 호출한 지점에 함수 본문을 그대로 복붙하는 함수
 * 실제 디컴파일 해보면, 함수 호출이 아닌 본문(this + other)에 파라미터가 적용되는 것을 확인할 수 있음
 *
 * 함수를 파라미터로 전달할 때의 오버헤드를 줄일 수 있음
 * - 함수를 중첩해서 사용하는 경우, 함수 call chain에 오버헤드 발생으로 성능 저하
 * ** inline 함수의 사용은 성능 측정과 함께 신중하게 사용되어야 함(Kotlin은 내부적으로 inline 함수가 적절하게 구현되어 있음)
 */
inline fun Int.add3(other: Int): Int {
    return this + other
}



fun createPerson1(firstName: String, lastName: String): JavaPerson {
    if (firstName.isEmpty()) {
        throw IllegalArgumentException("firstName cannot be empty! firstName: ${firstName}")
    }

    if (lastName.isEmpty()) {
        throw IllegalArgumentException("lastName cannot be empty! lastName: ${lastName}")
    }

    return JavaPerson(firstName, lastName, 100)
}

/**
 * 지역 함수
 * 함수로 추출하면 좋을 것 같은데, 이 함수를 지금 함수 내에서만 사용하고 싶을 경우 활용
 * depth가 깊어지고, 코드가 그렇게 깔끔하지 않음, JavaPerson 클래스에서 private 함수로 검증해주는 것이 나음
 */
fun createPerson2(firstName: String, lastName: String): JavaPerson {
    // 지역 함수
    fun validateName(name: String, fieldName: String) {
        if (name.isEmpty()) {
            throw IllegalArgumentException("${fieldName} cannot be empty! ${fieldName}: ${name}")
        }
    }
    validateName(firstName, "firstName")
    validateName(lastName, "lastName")

    return JavaPerson(firstName, lastName, 100)
}