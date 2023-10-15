package initialization;

public class Initialization {
    public static void main(String[] args) {
        new Child();
    }
}

class Person {
    Person(){
        System.out.print("4");
    }
    static {
        System.out.print("1");
    }
    {
        System.out.print("3");
    }

}
class Child extends Person{
    static {
        System.out.print("2");
    }
    {
        System.out.print("5");
    }
    Child(){
        System.out.print("6");
    }
}
