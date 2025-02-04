package Lec17;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lec17Main {
    public static void main(String[] args) {
        List<JavaFruit> fruits = List.of(
                new JavaFruit("사과", 1_000),
                new JavaFruit("사과", 1_200),
                new JavaFruit("사과", 1_400),
                new JavaFruit("바나나", 2_000),
                new JavaFruit("바나나", 2_200),
                new JavaFruit("바나나", 2_400)
        );
        
        System.out.println(isApple(fruits.get(0)));
        filterFruits(fruits, fruit -> isApple(fruit));
        filterFruits(fruits, Lec17Main::isApple);
        
        
        String targetFruitName = "바나나";
        targetFruitName = "사과";
        // targetFruitName에서 컴파일 에러
        // Java에서는 람다를 쓸 때, final인 변수 혹은 실질적으로 final인 변수만 사용 가능 / 람다에 사용할 수 있는 변수에 제약이 있음
        // ㄴ 코틀린은 그렇지 않다
//        filterFruits(fruits, fruit -> targetFruitName.equals(fruit.getName()));
    }
    
    private static boolean isApple(JavaFruit fruit) {
        return fruit.getName().equals("사과");
    }
    
    private static List<JavaFruit> filterFruits(List<JavaFruit> fruits, Predicate<JavaFruit> fruitFilter) {
        return fruits.stream()
                .filter(fruitFilter)
                .collect(Collectors.toList());
    }
}
