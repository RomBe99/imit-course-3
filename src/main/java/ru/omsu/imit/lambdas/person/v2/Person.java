package ru.omsu.imit.lambdas.person.v2;

import java.util.Objects;

public class Person {
    private String name;
    private Person mother;
    private Person father;

    public Person(final String name, final Person mother, final Person father) {
        setName(name);
        setMother(mother);
        setFather(father);
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setMother(final Person mother) {
        this.mother = mother;
    }

    public void setFather(final Person father) {
        this.father = father;
    }

    public String getName() {
        return name;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public Person getMothersMotherFather() {
        final int DEPTH = 2;
        Person temp = this;

        for (int i = 0; i < DEPTH; i++) {
            if (temp.mother == null) {
                return null;
            }

            temp = temp.mother;
        }

        return temp.father;
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