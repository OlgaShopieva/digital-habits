package immutable;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("city", "street", 1);
        Student student = new Student(1, "Alex", address);
        System.out.println(student);
        student.getAddress().setCity("new city");
        System.out.println(student);
    }
}
