package Lec08;

public class Lec08 {
    
    public static void main(String[] args) {
        String[] arr = new String[]{"A", "B", "C"};
        printAll(arr);
        
        printAll("D", "E", "F");
    }
    
    public int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }
    
    public void repeat(String str, int num, boolean useNewLine) {
        for (int i = 1; i <= num; i++) {
            if (useNewLine) {
                System.out.println(str);
            } else {
                System.out.print(str);
            }
        }
    }
    
    public void repeat(String str, int num) {
        repeat(str, num, true);
    }
    
    public void repeat(String str) {
        repeat(str, 3, true);
    }
    
    public static void printAll(String... strings) {
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
