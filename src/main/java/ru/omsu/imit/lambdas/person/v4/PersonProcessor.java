package ru.omsu.imit.lambdas.person.v4;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PersonProcessor {
    private PersonProcessor() {
    }

    public static final Function<List<Person>, List<String>> sortByNameLength = l -> l.stream()
            .filter(p -> p != null && p.getAge() >= 30)
            .map(Person::getName)
            .distinct()
            .sorted(Comparator.comparing(String::length))
            .collect(Collectors.toList());

    public static final Function<List<Person>, List<String>> sortByNameCount = l -> l.stream()
            .filter(p -> p != null && p.getAge() >= 30)
            .map(Person::getName)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.toList()))
            .values().stream()
            .sorted(Comparator.comparing(List::size))
            .map(strings -> strings.iterator().next())
            .collect(Collectors.toList());
}