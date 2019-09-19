package ru.omsu.imit.nio.trainee;

public class TraineeException extends Exception {
    private TraineeErrorCode errorCode;

    public TraineeException(TraineeErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public TraineeErrorCode getErrorCode() {
        return errorCode;
    }
}