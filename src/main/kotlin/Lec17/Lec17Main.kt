package Lec17

/**
 * 함수는 Java에서는 2급 시민, Kotlin에서는 1급 시민
 *  ㄴ 때문에, 함수 자체를 변수에 넣을 수도 있고 파라미터로 직접 전달할 수도 있음
 * 코틀린에서 함수 타입은 (파라미터 타입, ...) -> 반환 타입
 * 코틀린에서 람다는 2가지 방법으로 만들 수 있고, {}를 사용하는 방식이 더 많이 사용됨
 * 함수를 호출하며, 마지막 파라미터인 람다를 쓸 때에는 소괄호 밖으로 람다를 뺄 수 있음
 * 람다의 마지막 expression 결과는 람다의 반환 값임
 * 코틀린에서는 Closure를 사용하여 non-final 즉, 가변 변수도 람다에서 사용 가능함
 */
fun main() {
    val fruits = listOf(
        JavaFruit("사과", 1_000),
        JavaFruit("사과", 1_200),
        JavaFruit("사과", 1_400),
        JavaFruit("바나나", 2_000),
        JavaFruit("바나나", 2_200),
        JavaFruit("바나나", 2_400),
    )

    // 이름 없는 함수, 익명 함수, 람다
    // 방법 1
    val isApple: (JavaFruit) -> Boolean = fun(fruit: JavaFruit): Boolean {
        return fruit.name == "사과"
    }

    // 방법 2
    val isApple2: (JavaFruit) -> Boolean = { fruit: JavaFruit -> fruit.name == "사과" }

    isApple(fruits[0])
    isApple.invoke(fruits[0])



    filterFruits(fruits, isApple2)
    filterFruits(fruits, { fruit: JavaFruit -> fruit.name == "사과" })
    // isApple2 처럼 중괄호 익명함수가 맨 마지막 파라미터에 위치할 때 아래와 같이 사용할 수 있음
    filterFruits(fruits) { fruit: JavaFruit -> fruit.name == "사과" }
    // 타입 생략 가능 - filterFruits 함수에서 타입 추론 가능 (위, 아래 방식 중 해당 방식을 가장 추천)
    filterFruits(fruits) { fruit -> fruit.name == "사과" }
    // fruit을 다르게 명명 가능
    filterFruits(fruits) { a -> a.name == "사과" }
    // 파라미터가 한 개인 경우 it 사용 가능
    filterFruits(fruits) { it.name == "사과" }
    // 람다는 여러 줄 작성할 수 있으며, 마지막 줄의 결과가 람다의 반환값임
    filterFruits(fruits) { fruit ->
        println("사과만 받는당")
        fruit.name == "사과"
    }



    // Closure
    var targetFruitName = "banana"
    targetFruitName = "apple"
    // 코틀린에서는 람다에 사용할 수 있는 변수에 제약이 없음 (final)
    // 코틀린에서는 람다가 시작하는 지점에 참조하고 있는 변수들을 모두 포획하여 그 정보를 가지고 있기 때문
    filterFruits(fruits) { it.name == targetFruitName }
}

private fun filterFruits(
    fruits: List<JavaFruit>,
    filter: (JavaFruit) -> Boolean
): List<JavaFruit> {
    val results = mutableListOf<JavaFruit>()
    for (fruit in fruits) {
        if (filter.invoke(fruit)) {
            results.add(fruit)
        }
    }
    return results
}

private fun filterFruits2(
    fruits: List<JavaFruit>,
    filter: (JavaFruit) -> Boolean
): List<JavaFruit> {
    return fruits.filter(filter)
}

private fun filterFruits3(
    fruits: List<JavaFruit>,
    filter: (JavaFruit) -> Boolean
): List<JavaFruit> {
    return fruits.stream()
        .filter(filter)
        .toList()
}
