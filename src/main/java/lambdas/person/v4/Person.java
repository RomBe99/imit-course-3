package lambdas.person.v4;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private int age;

    public Person(final String name, final int age) {
        setName(name);
        setAge(age);
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static final Function<List<Person>, List<Person>> sortByNameLength = l -> l.stream().
            filter(p -> p.getAge() >= 30).
            collect(Collectors.toList());

    public static final Function<List<Person>, List<Person>> sortByEqualsName = null;
}