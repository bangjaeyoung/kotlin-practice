package Lec11

/**
 * public: 모든 곳에서 접근 가능
 * protected: **선언된 클래스** 또는 하위 클래스에서만 접근 가능
 * internal: 같은 모듈에서만 접근 가능 (Java와 다른점)
 * private: 선언된 클래스 내에서만 접근 가능
 *
 * 1. Kotlin에서 패키지는 namespace 관리용이기 때문에 protected 의미가 달라짐
 * 2. Kotlin에서는 default가 사라지고, 모듈 간의 접근을 통제하는 internal이 새로 생김
 * 3. 생성자에 접근 지시어를 붙일 때는 constructor를 명시적으로 작성해주어야 함
 * 4. 유틸성 함수를 만들 때는 파일 최상단을 이용하면 편리함
 * 5. 프로퍼티의 custom setter에 접근 지시어를 붙일 수 있음
 * 6. Java에서 Kotlin 코드를 사용할 때, internal과 protected는 주의해야 함
 */

// 유틸리티성 함수는 코틀린에서 파일 최상단에 작성하는 게 편함
fun isDirectoryPath(path: String): Boolean {
    return path.endsWith("/")
}

// 코틀린은 하나의 파일 안에서 변수, 함수, 클래스 모두 만들 수 있음
val num = 3

fun add(a: Int, b: Int): Int {
    return a + b
}

// 생성자에 접근 지시자 사용 가능 - constructor 키워드 필수로 붙여야 함
class Cat private constructor(

)

class Car(
    // default 생성자의 프로퍼티에 접근 지시자 사용 가능
    internal val name: String,
    private var owner: String,
    _price: Int
) {

    // 특정 프로퍼티의 setter에만 접근 지시자 사용 가능
    var price = _price
        private set
}
