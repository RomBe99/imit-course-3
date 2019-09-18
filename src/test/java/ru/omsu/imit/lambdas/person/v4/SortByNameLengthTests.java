package ru.omsu.imit.lambdas.person.v4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RunWith(Parameterized.class)
public class SortByNameLengthTests extends Assert {
    private List<Person> testList;
    private List<String> expectedList;

    public SortByNameLengthTests(final List<Person> testList, final List<String> expectedList) {
        this.testList = testList;
        this.expectedList = expectedList;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final List<Person> TEST_LIST1 = Arrays.asList(
                new Person("Анна", 25),
                new Person("Анна", 25),
                new Person("Анна", 31),
                new Person("Анна", 31),

                new Person("Олег", 20),
                new Person("Олег", 33),
                new Person("Олег", 33),
                new Person("Олег", 31),

                new Person("Александр", 31),
                new Person("Александр", 31),
                new Person("Александр", 31),
                null
        );

        Collections.shuffle(TEST_LIST1);

        return Arrays.asList(new Object[][]{
                {TEST_LIST1, Arrays.asList("Олег", "Анна", "Александр")},
                {Collections.EMPTY_LIST, Collections.EMPTY_LIST}
        });
    }

    @Test
    public void sortByNameLengthTest() {
        final List<String> ACTUAL = Person.sortByNameLength.apply(testList);

        assertEquals(expectedList, ACTUAL);
    }
}