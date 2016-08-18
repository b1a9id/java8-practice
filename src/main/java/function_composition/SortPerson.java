package function_composition;

import java.util.Comparator;

public class SortPerson {

    public static Comparator<Person> firstLastSort() {
        Comparator<Person> comparator = (p1, p2) -> {
            //姓で比較
            String last1 = p1.getLast();
            String last2 = p2.getLast();
            int result = last1.compareTo(last2);

            if (result != 0) {
                return result;
            } else {
                // 姓が同じ場合、名で比較
                String first1 = p1.getFirst();
                String first2 = p2.getFirst();
                return first1.compareTo(first2);
            }
        };

        return comparator;
    }

    public static Comparator<Person> firstLastSortWithThenComparing() {
        // 姓で比較
        Comparator<Person> lastNameComparator = (p1, p2) -> {
            String last1 = p1.getLast();
            String last2 = p2.getLast();

            return last1.compareTo(last2);
        };

        // 名で比較
        Comparator<Person> firstNameComparator = (p1, p2) -> {
            String first1 = p1.getFirst();
            String first2 = p2.getFirst();
            return first1.compareTo(first2);
        };

        // 姓で比較した後、名で比較する
        return lastNameComparator.thenComparing(firstNameComparator);
    }
}