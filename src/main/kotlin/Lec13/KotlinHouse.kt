fun main() {

}

/**
 * Kotlin은 내부 클래스에 static이 붙은 방식을 따름
 * Java - 내부 static 클래스 = Kotlin - 내부 일반 클래스
 * Java - 내부 일반 클래스 = Kotlin - 내부 inner 클래스
 */
class KotlinHouse(
    private val address: String,
    private val livingRoom: LivingRoom
) {

    // Kotlin에서의 중첩 클래스 생성
    class LivingRoom(
        // 권장되지 않는(외부 클래스를 참조하는) 내부 클래스 생성 방법 - inner 키워드
//    inner class LivingRoom(
        private val area: Double
    ) {
        // 외부 클래스 참조 방법 - this@외부클래스
//        val address: String
//            get() = this@KotlinHouse.address
    }
}
