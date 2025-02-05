package Lec18

fun main() {
    val fruits = listOf(
        Fruit(1L, "apple", 1_000L, 1_200L),
        Fruit(2L, "apple", 1_500L, 1_700L),
        Fruit(3L, "apple", null, 2_200L),
        Fruit(4L, "banana", 2_500L, 2_700L),
        Fruit(5L, "banana", 3_000L, 3_200L),
    )

    // filter
    val apples = fruits.filter { fruit -> fruit.name == "apple" }

    // filterIndexed
    val apples2 = fruits.filterIndexed { index, fruit ->
        println(index)
        fruit.name == "apple"
    }

    // map
    val apples3 = fruits.filter { fruit -> fruit.name == "apple" }
        .map { fruit -> fruit.currentPrice }

    // mapIndexed
    val apples4 = fruits.filter { fruit -> fruit.name == "apple" }
        .mapIndexed { index, fruit ->
            println(index)
            fruit.currentPrice
        }

    // mapNotNull
    val apples5 = fruits.filter { fruit -> fruit.name == "apple" }
        .mapNotNull { fruit -> fruit.nullOrValue() }



    filterFruits(fruits) {fruit ->  fruit.name == "apple"}
    filterFruits2(fruits) {fruit ->  fruit.name == "apple"}



    // all
    val isAllApple = fruits.all { fruit -> fruit.name == "apple" }

    // none
    val isNoApple = fruits.none { fruit -> fruit.name == "apple" }

    // any
    val isApple6 = fruits.any { fruit -> fruit.name == "apple" }

    // count
    val fruitCount = fruits.count()

    // sortedBy
    val fruitSortedByAscending = fruits.sortedBy { fruit -> fruit.currentPrice }
    val fruitSortedByDescending = fruits.sortedByDescending { fruit -> fruit.currentPrice }

    // distinctBy
    val distinctFruitsName = fruits.distinctBy { fruit -> fruit.name }
        .map { fruit -> fruit.name }

    // first, firstOrNull
    fruits.first()
    fruits.firstOrNull()

    // last, lastOrNull
    fruits.last()
    fruits.lastOrNull()



    // groupBy, associateBy

    // Key: 과일 이름, Value: List<과일>
    val map: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }
    println(map)

    // Key: id, Value: 과일
    val map2: Map<Long, Fruit> = fruits.associateBy { fruit -> fruit.id }
    println(map2)

    // Key: 과일 이름, Value: List<과일 현재가>
    val map3: Map<String, List<Long>> = fruits
        .groupBy( {fruit -> fruit.name}, {fruit -> fruit.currentPrice} )

    // Key: id, Value: 과일 현재가
    val map4: Map<Long, Long> = fruits
        .associateBy( {fruit -> fruit.id}, {fruit -> fruit.currentPrice} )

    val map5: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }
        .filter { (key, value) -> key == "apple" }



    val fruitsInList: List<List<Fruit>> = listOf(
        listOf(
            Fruit(1L, "apple", 1_000L, 1_000L),
            Fruit(2L, "apple", 1_000L, 1_500L),
        ),
        listOf(
            Fruit(3L, "banana", 2_000L, 2_000L),
            Fruit(4L, "banana", 2_000L, 2_500L),
        ),
        listOf(
            Fruit(5L, "mandarin", 3_000L, 3_000L),
            Fruit(6L, "mandarin", 3_000L, 3_500L),
        ),
    )

    // flatMap: List<List<>>를 단일 List<>로 변경, 변환(mapping) + 평탄화(flattening) 동시 수행
    val samePriceFruits = fruitsInList.flatMap { list ->
        list.filter { fruit -> fruit.factoryPrice == fruit.currentPrice }
    }
    println(samePriceFruits)

    // 확장 함수 사용
    val samePriceFruits2 = fruitsInList.flatMap { list -> list.samePriceFilter }
    println(samePriceFruits2)

    // flatten: List<List<>>를 단일 List<>로 변경, 평탄화(flattening)만 수행
    val flattenFruits = fruitsInList.flatten()
    println(flattenFruits)
}

// 확장 함수
val List<Fruit>.samePriceFilter: List<Fruit>
    get() = this.filter { fruit -> fruit.isSamePrice }

data class Fruit(
    val id: Long,
    val name: String,
    val factoryPrice: Long?,
    val currentPrice: Long,
) {
    fun nullOrValue(): Long? {
        return factoryPrice
    }

    val isSamePrice: Boolean
        get() = this.factoryPrice == this.currentPrice
}

private fun filterFruits(
    fruits: List<Fruit>,
    filter: (Fruit) -> Boolean,
): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter(fruit)) {
            results.add(fruit)
        }
    }
    return results
}

private fun filterFruits2(
    fruits: List<Fruit>,
    filter: (Fruit) -> Boolean,
): List<Fruit> {
    return fruits.filter(filter)
}