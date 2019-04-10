import java.util.Arrays;
import java.util.Comparator;

public class LambdaTest2 {
    public static void main(String[] args) {
        Person[] person = {
            new Person("gg",23),
            new Person("hh",25),
            new Person("jj",21),
        };

        Arrays.sort(person,(Person a,Person b)->a.getAge()-b.getAge());
//        Comparator<Person> comp = new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        };
//        Arrays.sort(person,comp);
        for (Person i:person) {
            System.out.println(i);
        }
    }
}
