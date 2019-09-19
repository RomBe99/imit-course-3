package ru.omsu.imit.lambdas.person.v4;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PersonProcessorTests extends Assert {
    @Test
    public void sortByNameCountTest1() {
        final List<Person> TEST_LIST = Arrays.asList(
                new Person("Анна", 25),
                new Person("Анна", 25),
                new Person("Анна", 31),
                new Person("Анна", 31),

                new Person("Олег", 20),
                new Person("Олег", 33),
                new Person("Олег", 33),
                new Person("Олег", 31),
                new Person("Олег", 31),

                new Person("Александр", 31),
                new Person("Александр", 31),
                new Person("Александр", 31),
                null
        );

        Collections.shuffle(TEST_LIST);

        final List<String> EXPECTED_LIST = Arrays.asList("Анна", "Александр", "Олег");
        final List<String> ACTUAL = PersonProcessor.sortByNameCount.apply(TEST_LIST);

        assertEquals(EXPECTED_LIST, ACTUAL);
    }

    @Test
    public void sortByNameCountEmptyListTest() {
        final List<String> ACTUAL = PersonProcessor.sortByNameCount.apply(new ArrayList<>());

        assertEquals(Collections.EMPTY_LIST, ACTUAL);
    }

    @Test
    public void sortByNameLengthTest1() {
        final List<Person> TEST_LIST = Arrays.asList(
                new Person("Анна", 25),
                new Person("Анна", 25),
                new Person("Анна", 31),
                new Person("Анна", 31),

                new Person("Олег", 20),
                new Person("Олег", 33),

                new Person("Александр", 31),
                new Person("Александр", 31),
                new Person("Александр", 31),
                null
        );

        Collections.shuffle(TEST_LIST);

        final List<String> EXPECTED_LIST = Arrays.asList("Олег", "Анна", "Александр");
        final List<String> ACTUAL = PersonProcessor.sortByNameLength.apply(TEST_LIST);

        assertEquals(EXPECTED_LIST, ACTUAL);
    }

    @Test
    public void sortByNameLengthEmptyListTest() {
        final List<String> ACTUAL = PersonProcessor.sortByNameLength.apply(new ArrayList<>());

        assertEquals(Collections.EMPTY_LIST, ACTUAL);
    }
}