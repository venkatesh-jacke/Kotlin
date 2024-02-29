package dataClass;

public class DataClass {
    public static void main(String[] args) {
        Person p1= new Person("venkat",23);
        Person p2= new Person("venkat",23);


        //Different result
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        //memory address of the object
        System.out.println(p1.toString());
        System.out.println(p2.toString());

    }
    static class Person{
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
