package ru.omsu.imit.nio.trainee;

import java.util.Objects;

public class Trainee {
    private String firstName;
    private String lastName;
    private int mark;

    public Trainee(final String firstName, final String lastName, final int mark) throws TraineeException {
        setFirstName(firstName);
        setLastName(lastName);
        setMark(mark);
    }

    public void setFirstName(final String firstName) throws TraineeException {
        if (firstName == null || "".equals(firstName)) {
            throw new TraineeException(TraineeErrorCode.INCORRECT_FIRST_NAME);
        }

        this.firstName = firstName;
    }

    public void setLastName(final String lastName) throws TraineeException {
        if (lastName == null || "".equals(lastName)) {
            throw new TraineeException(TraineeErrorCode.INCORRECT_LAST_NAME);
        }

        this.lastName = lastName;
    }

    public void setMark(final int mark) throws TraineeException {
        if (mark > 5 || mark < 1) {
            throw new TraineeException(TraineeErrorCode.INCORRECT_MARK);
        }

        this.mark = mark;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getMark() {
        return mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainee trainee = (Trainee) o;
        return mark == trainee.mark &&
                Objects.equals(firstName, trainee.firstName) &&
                Objects.equals(lastName, trainee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, mark);
    }
}