package function_composition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

public class PersonMain {

    public static void main(String[] args) {
        BiFunction<String, String, Person> function = Person::new;
        Person p1 = function.apply("Taro", "Tanaka");
        Person p2 = function.apply("Hanako", "Yamada");
        Person p3 = function.apply("Isamu", "Inoue");
        List<Person> persons = new ArrayList<>(Arrays.asList(p1, p2, p3));

        Comparator<Person> comparator = SortPerson.firstLastSortWithThenComparing();

        int result = comparator.compare(p1, p2);
        System.out.println(result);
    }
}
