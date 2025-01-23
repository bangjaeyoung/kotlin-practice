package Lec04;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class JavaMoney implements Comparable<JavaMoney> {
    
    private final long amount;
    
    public JavaMoney(long amount) {
        this.amount = amount;
    }
    
    public JavaMoney plus(JavaMoney other) {
        return new JavaMoney(this.amount + other.amount);
    }
    
    @Override
    public int compareTo(@NotNull JavaMoney o) {
        return Long.compare(this.amount, o.amount);
    }
    
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        JavaMoney javaMoney = (JavaMoney) object;
        return amount == javaMoney.amount;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(amount);
    }
    
    @Override
    public String toString() {
        return "JavaMoney{" +
                "amount=" + amount +
                '}';
    }
}
