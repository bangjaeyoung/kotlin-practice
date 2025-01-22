package Lec03;

import Lec02.Person;

public class Lec03 {
    
    public static void main(String[] args) {
    
    }
    
    public void printAgeIfPerson(Object obj) {
        if (obj instanceof Object) {
            Person person = (Person) obj;
            System.out.println(person.getName());
        }
    }
}
