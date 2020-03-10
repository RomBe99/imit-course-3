package ru.omsu.imit.multithreading.task17;

import ru.omsu.imit.multithreading.task16.Executable;

import java.util.List;

import static java.lang.Thread.sleep;

public class Task implements Executable {
    private String name;
    private List<Executable> stages;

    public Task(List<Executable> stages) {
        this.stages = stages;
    }

    public Task(String name, int number) {
        this.name = name + " " + number;
        stages = null;
    }

    boolean isEnd() {
        return stages.size() == 1;
    }

    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        try {
            sleep(500);

            if (stages != null) {
                stages.remove(0).execute();
            } else {
                System.out.println(name + " done!");
            }

            if (stages != null && stages.isEmpty()) {
                System.out.println(name + " done");
            }
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}