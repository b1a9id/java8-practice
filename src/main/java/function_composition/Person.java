package function_composition;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private String first;

    private String last;

    public Person(String first, String last) {
        this.first = first;
        this.last = last;
    }
}
