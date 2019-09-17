package ru.omsu.imit.lambdas.person.v3;

import java.util.Objects;
import java.util.Optional;

public class Person {
    private String name;
    private Optional<Person> mother;
    private Optional<Person> father;

    public Person(final String name, final Person mother, final Person father) {
        setName(name);
        setMother(mother);
        setFather(father);
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setMother(final Person mother) {
        this.mother = Optional.ofNullable(mother);
    }

    public void setFather(final Person father) {
        this.father = Optional.ofNullable(father);
    }

    public String getName() {
        return name;
    }

    public Person getMother() {
        return mother.orElse(null);
    }

    public Person getFather() {
        return father.orElse(null);
    }

    public Person getMothersMotherFather() {
        return mother.
                flatMap(m -> m.mother).
                flatMap(m -> m.father).
                orElse(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(mother, person.mother) &&
                Objects.equals(father, person.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mother, father);
    }
}