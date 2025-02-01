package Lec14

fun main() {
    handleCar(Avante())
}

private fun handleCar(car: HyundaiCar) {
    when (car) {
        is Avante -> TODO()
        is Sonata -> TODO()
        is Grendeur -> TODO()
    }
}

// sealed class
// 컴파일 타임 때 하위 클래스의 타입을 모두 기억함. 즉, 런타임 때 클래스 타입이 추가될 수 없음
// 하위 클래스는 같은 패키지에 있어야 함
// Enum과 다른 점은 클래스를 상속받을 수 있으며, 하위 클래스는 멀티 인스턴스가 가능함
// ** 추상화가 필요한 Entity or DTO에 sealed class 사용 가능
sealed class HyundaiCar(
    val name: String,
    val price: Long,
)

class Avante : HyundaiCar("아반떼", 1_000L)

class Sonata : HyundaiCar("소나타", 2_000L)

class Grendeur : HyundaiCar("그랜저", 3_000L)
