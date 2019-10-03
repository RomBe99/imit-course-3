package ru.omsu.imit.lambdas.person.v1;

import org.junit.Assert;
import org.junit.Test;

public class PersonTests extends Assert {
    @Test
    public void personTest1() {
        final Person EXPECTED_PERSON = new Person("Igor");
        final Person ACTUAL = Person.create.apply(EXPECTED_PERSON);

        assertEquals(EXPECTED_PERSON, ACTUAL);
    }

    @Test
    public void personTest2() {
        final Person EXPECTED_PERSON = new Person("");
        final Person ACTUAL = Person.create.apply(EXPECTED_PERSON);

        assertEquals(EXPECTED_PERSON, ACTUAL);
    }

    @Test
    public void personNullTest1() {
        final Person EXPECTED_PERSON = new Person(null);
        final Person ACTUAL = Person.create.apply(EXPECTED_PERSON);

        assertEquals(EXPECTED_PERSON, ACTUAL);
    }

    @Test
    public void personNullTest2() {
        final Person ACTUAL = Person.create.apply(null);

        assertNull(ACTUAL);
    }
}