package ru.omsu.imit.lambdas.person.v1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PersonTests extends Assert {
    private String personName;
    private Person expectedPerson;

    public PersonTests(final String personName, final Person expectedPerson) {
        this.personName = personName;
        this.expectedPerson = expectedPerson;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final String PERSON1_NAME = "Igor";
        final Person EXPECTED_PERSON1 = new Person(PERSON1_NAME);

        final String PERSON2_NAME = "";
        final Person EXPECTED_PERSON2 = new Person(PERSON2_NAME);
        
        return Arrays.asList(new Object[][]{
                {PERSON1_NAME, EXPECTED_PERSON1},
                {PERSON2_NAME, EXPECTED_PERSON2},
                {null, new Person(null)}
        });
    }

    @Test
    public void personTest() {
        final Person ACTUAL = Person.create.apply(personName);

        assertEquals(expectedPerson, ACTUAL);
    }
}