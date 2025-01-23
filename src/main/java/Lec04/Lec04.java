package Lec04;

public class Lec04 {
    
    public static void main(String[] args) {
        JavaMoney money1 = new JavaMoney(2_000L);
        JavaMoney money2 = new JavaMoney(1_000L);
        
        if (money1.compareTo(money2) > 0) {
            System.out.println("Money1이 Money2보다 금액이 크다.");
        }
        
        JavaMoney money3 = new JavaMoney(1_000L);
        JavaMoney money4 = money3;
        JavaMoney money5 = new JavaMoney(1_000L);
        
        System.out.println(money3 == money4);
        System.out.println(money3.equals(money5));
        
        JavaMoney money6 = new JavaMoney(2_000L);
        JavaMoney money7 = new JavaMoney(1_000L);
        System.out.println(money6.plus(money7));
    }
}
