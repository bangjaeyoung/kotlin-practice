package Lec12

fun main() {
    println(KotlinPerson.newBaby("bang"))

    println(Singleton.a)
    Singleton.a += 10
    println(Singleton.a)
}

class KotlinPerson private constructor(
    private var name: String,
    private var age: Int
) {
    // companion object: 클래스와 동행하는 유일한 오브젝트 (Java에서의 static 역할)
    // companion object, 즉 동반객체도 하나의 객체로 간주되며, 이름을 붙일 수도 있고 interface를 구현할 수도 있음
    // companion object에 유틸성 함수들을 넣어도 되지만, 최상단 파일을 활용하는 것을 추천!
    companion object Factory : Log {
        // const X: 런타임 시에 변수 할당, const O: 컴파일 시에 변수 할당
        // 진짜 상수에 붙이기 위한 용도로, 기본 타입과 String에 붙일 수 있음
        private const val MIN_AGE: Int = 1

        @JvmStatic
        fun newBaby(name: String): KotlinPerson {
            return KotlinPerson(name, MIN_AGE)
        }

        override fun log() {
            println("Log Log!")
        }
    }
}

// 싱글톤 클래스 생성
object Singleton {
    var a: Int = 0
}
