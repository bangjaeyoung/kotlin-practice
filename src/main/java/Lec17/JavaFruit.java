package Lec17;

public class JavaFruit {
    
    private final String name;
    private final int price;
    
    public JavaFruit(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public int getPrice() {
        return price;
    }
}
