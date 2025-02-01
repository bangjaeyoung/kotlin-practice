package Lec12;

public class Lec12Main {
    public static void main(String[] args) {
        // Kotlin으로 구현한 companion object 호출
//        KotlinPerson.Companion.newBaby("Bang"); // companion object 이름이 없는 경우
        KotlinPerson.newBaby("Bang");   // @JvmStatic 사용
        KotlinPerson.Factory.newBaby("Bang");   // companion object 이름이 있는 경우
        
        // 익명 클래스: 특정 인터페이스나 클래스를 상속받은 구현체를 일회성으로 사용할 때 쓰는 클래스
        // 익명 클래스 사용
        moveSomething(new Movable() {
            @Override
            public void move() {
                System.out.println("move move!");
            }
            
            @Override
            public void fly() {
                System.out.println("fly fly!");
            }
        });
    }
    
    private static void moveSomething(Movable movable) {
        movable.move();
        movable.fly();
    }
}
