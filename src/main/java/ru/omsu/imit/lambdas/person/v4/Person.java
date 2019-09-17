package ru.omsu.imit.lambdas.person.v4;

import java.util.List;
import java.util.function.Function;

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

    public static final Function<List<Person>, List<Person>> sortByNameLength = null;

    public static final Function<List<Person>, List<Person>> sortByEqualsName = null;
}