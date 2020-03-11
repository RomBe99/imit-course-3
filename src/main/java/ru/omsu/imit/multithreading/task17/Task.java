package ru.omsu.imit.multithreading.task17;

import ru.omsu.imit.multithreading.task16.Executable;

import java.util.List;
import java.util.Objects;

public class Task implements Executable {
    public static final Task poison = new Task("Poison", null);
    private String subject;
    private List<Executable> stages;

    public Task(String subject, List<Executable> stages) {
        this.subject = subject;
        this.stages = stages;
    }

    @Override
    public void execute() {
        System.out.println("Doing " + subject);
    }

    public List<Executable> getStages() {
        return stages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return Objects.equals(subject, task.subject) &&
                Objects.equals(stages, task.stages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, stages);
    }
}
