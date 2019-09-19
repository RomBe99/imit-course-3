package ru.omsu.imit.nio.trainee;

public enum TraineeErrorCode {
    INCORRECT_FIRST_NAME("Incorrect first name"),
    INCORRECT_LAST_NAME("Incorrect name"),
    INCORRECT_MARK("Incorrect mark");

    private String errorMessage;

    TraineeErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}