package Lec15

fun main() {

    val array = arrayOf(100, 200)
    // 1
    for (i in array.indices) {
        println("${i} ${array[i]}")
    }
    // 2
    val plusArray = array.plus(300)
    for ((index, value) in plusArray.withIndex()) {
        println("${index} ${value}")
    }

    // 컬렉션을 만들어줄 때, 불변인지 가변인지를 설정해야 함
    // 불변 컬렉션이라 하더라도, Reference Type인 Element의 필드는 바꿀 수 있음
    // ** 우선 불변 리스트를 만들고, 꼭 필요한 경우에 가변 리스트로 바꾸자
    val numbers = listOf(100, 200)  // 불변 리스트
    val mutableNumbers = mutableListOf(100, 200)  // 가변 리스트
    mutableNumbers.add(300)

    // 비어있는 리스트 생성
    val emptyList = emptyList<Int>()
    // 타입 추론으로 인한 타입 생략 가능
    useNumbers(emptyList())

    // 하나 가져오기
    println(numbers[0])

    // for each
    for (number in numbers) {
        println(number)
    }

    // 전통적인 for문
    for ((index, value) in numbers.withIndex()) {
        println("${index} ${value}")
    }

    val numbersSet = setOf(100, 200)
    val mutableNumbersSet = mutableSetOf(100, 200)

    // for each
    for (number in numbersSet) {
        println(number)
    }

    for ((index, value) in numbersSet.withIndex()) {
        println("${index} ${value}")
    }

    val map = mutableMapOf<Int, String>()
    map[1] = "MONDAY"
    map[2] = "TUESDAY"

    val map2 = mapOf(1 to "MONDAY", 2 to "TUESDAY")

    for (key in map.keys) {
        println(key)
        println(map[key])
    }

    for ((key, value) in map2) {
        println(key)
        println(value)
    }

    /**
     * 컬렉션의 null 구분 차이 확실하게 하기
     * List<Int?> : 리스트에 null이 들어갈 수 있지만, 리스트는 절대 null이 아님
     * List<Int>? : 리스트에 null이 들어갈 수 없지만, 리스트는 null일 수 있음
     * List<Int?>? : 리스트에 null이 들어갈 수도 있고, 리스트가 null일 수도 있음
     *
     * Java는 읽기 전용 컬렉션과 변경 가능 컬렉션을 구분하지 않음
     *  - Java에서 Kotlin 컬렉션을 가져갈 때는 불변 컬렉션을 수정할 수도 있음
     * Java는 nullable 타입과 non-nullable 타입을 구분하지 않음
     *  - Java에서 Kotlin 컬렉션을 가져갈 때는 non-nullable 컬렉션에 null을 넣을 수도 있음
     * Kotlin 쪽의 컬렉션이 Java에서 호출되면 컬렉션 내용이 변할 수 있음을 감안해야 함
     *  - Kotlin 쪽에서 Collections.unmodifableXXX()를 활용하면 변경 자체를 막을 수 있음
     * Kotlin에서 Java 컬렉션을 가져다 사용할 때는 플랫폼 타입을 신경써야 함
     *  - Java 코드를 보며, 맥락을 확인하고 Java 코드를 가져오는 지점을 wrapping 하는 방법이 있음
     */
}

private fun useNumbers(numbers: List<Int>) {

}