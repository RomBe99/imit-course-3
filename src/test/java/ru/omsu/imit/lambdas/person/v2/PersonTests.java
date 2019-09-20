package ru.omsu.imit.lambdas.person.v2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.omsu.imit.lambdas.person.v2.Person;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PersonTests extends Assert {
    private Person testPerson;
    private Person expectedPerson;

    public PersonTests(final Person testPerson, final Person expectedPerson) {
        this.testPerson = testPerson;
        this.expectedPerson = expectedPerson;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final Person EXPECTED_PERSON1 = new Person("Igor", null, null);
        final Person TEST_PERSON1 = new Person("Anya", new Person("Irina", new Person("Dasha", null, EXPECTED_PERSON1), null), null);

        final Person TEST_PERSON2 = new Person("Ilya", new Person("Irina",null, null), null);
        final Person TEST_PERSON3 = new Person("Anton", null, null);

        return Arrays.asList(new Object[][]{
                {TEST_PERSON1, EXPECTED_PERSON1},
                {TEST_PERSON2, null},
                {TEST_PERSON3, null}
        });
    }


    @Test
    public void getMothersMotherFatherTest() {
        final Person ACTUAL = testPerson.getMothersMotherFather();

        assertEquals(expectedPerson, ACTUAL);
    }
}