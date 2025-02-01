package Lec14;

// enum 클래스 특징: 추가적인 클래스를 상속받을 수 없으며, 인터페이스는 구현할 수 있음. 각 코드가 싱글톤임 (KOREA, AMERICA)
public enum JavaCountry {
    
    KOREA("KO"),
    AMERICA("US");
    
    private final String code;
    
    JavaCountry(String code) {
        this.code = code;
    }
    
    public String getCode() {
        return code;
    }
    
    private static void handleCountry(JavaCountry country) {
        if (country == JavaCountry.KOREA) {
            // ..
        }
        
        if (country == JavaCountry.AMERICA) {
            // ..
        }
    }
}
