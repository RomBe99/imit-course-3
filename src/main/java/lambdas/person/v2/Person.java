package lambdas.person.v2;

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

    // TODO Можно ли иначе?
    public Person getMothersMotherFather() {
        final int DEPTH = 2;
        Person temp = this;

        for (int i = 0; i < DEPTH; i++) {
            if (temp.mother == null) {
                return null;
            } else {
                temp = temp.mother;
            }
        }

        return temp.father;
    }
}