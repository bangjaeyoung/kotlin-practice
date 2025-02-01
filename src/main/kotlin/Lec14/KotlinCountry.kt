package Lec14

// else문 작성 필요 x
// 컴파일러가 country의 모든 타입을 알고 있기 때문에, 다른 타입에 대한 로직(else)을 작성하지 않아도 됨
// Enum 클래스에 변화가 있으면 알 수 있음 (값, 프로퍼티 추가 등)
fun handleCountry(country: KotlinCountry) {
    when (country) {
        KotlinCountry.KOREA -> TODO()
        KotlinCountry.AMERICA -> TODO()
    }
}

enum class KotlinCountry(
    private val code: String,
) {
    KOREA("KO"),
    AMERICA("US");
}
