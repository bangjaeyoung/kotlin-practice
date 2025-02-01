package Lec12;

public class JavaPerson {
    
    // static: 클래스가 인스턴스화될 때, 새로운 값이 복제되는 것이 아니라 정적으로 인스턴스끼리의 값을 공유
    private static final int MIN_AGE = 1;
    
    public static JavaPerson newBaby(String name) {
        return new JavaPerson(name, MIN_AGE);
    }
    
    private String name;
    private int age;
    
    private JavaPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
