package ru.omsu.imit.lambdas.person.v1;

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
}