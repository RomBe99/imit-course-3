package lambdas.person.v1;

public class Person {
    private String name;

    public Person(final String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}