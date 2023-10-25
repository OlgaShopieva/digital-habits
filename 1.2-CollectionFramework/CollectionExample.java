import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionExample {
    public static void main(String[] args) {
        //1.ArrayList
        List<String> list = new ArrayList<>();
        list.add("summer");
        list.add("autumn");
        list.add("winter");
        list.add("spring");

        //iterator over ArrayList
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String element = iterator.next();
            //System.out.println(element);
        }




        // Create a list of Person objects
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Charlie", 20));
        people.add(new Person("Dave", 35));
        people.add(new Person("Eve", 22));

        // Sort the list of Person objects by age using a Comparator
        Comparator<Person> ageComparator = new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.getAge() - p2.getAge();
            }
        };
        people.sort(ageComparator);

        // Filter the list of Person objects to include only those under the age of 30 using a Predicate
        Predicate<Person> ageFilter = new Predicate<Person>() {
            public boolean test(Person p) {
                return p.getAge() < 30;
            }
        };
        List<Person> youngPeople = people.stream().filter(ageFilter).toList();

        // Print the list of young people to the console
        for (Person person : youngPeople) {
            System.out.println(person.getName() + ", " + person.getAge());
        }






        //2.HashSet
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        for (int element: set) {
            //System.out.println(element);
        }

        //3.HashMap
        HashMap<String, Integer> map = new HashMap<>();
        map.put("banana", 70);
        map.put("orange", 85);
        map.put("apple", 90);

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
           // System.out.println(key + ": " + value);
        }
    }
}
