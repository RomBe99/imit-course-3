package ru.omsu.imit.lambdas.person.v4;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
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

    public static final Function<List<Person>, List<String>> sortByNameLength = l -> l.stream()
            .filter(p -> p != null && p.age >= 30)
            .map(p -> p.name)
            .distinct()
            .sorted(Comparator.comparing(String::length))
            .collect(Collectors.toList());

    public static final Function<List<Person>, List<String>> sortByNameCount = l -> l.stream()
            .filter(p -> p != null && p.age >= 30)
            .map(Person::getName)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.toList()))
            .values().stream()
            .sorted(Comparator.comparing(List::size))
            .map(strings -> strings.iterator().next())
            .collect(Collectors.toList());

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}