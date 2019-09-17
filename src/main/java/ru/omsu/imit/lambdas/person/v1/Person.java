package ru.omsu.imit.lambdas.person.v1;

import java.util.Objects;
import java.util.function.Function;

public class Person {
    private String name;

    public Person(final String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public static final Function<String, Person> create = Person::new;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}