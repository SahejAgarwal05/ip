package main.java;

public class Task {
    private String name;
    private boolean completed;

    public Task(String name) {
        this.name = name;
        this.completed = false;
    }

    public Task() {
        this.completed = false;
        this.name = "";
    }

    /**
     *
     * @return name of the task
     */
    public String getName() {
        return this.name;
    }

    /**
     * Change name of the task
     * @param name new name of the task
     *
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * check if task is completed
     * @return true for completed task and false for incomplete task
     */
    public boolean isCompleted() {
        return this.completed;
    }

    /**
     * Change status of task
     * @param completed
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Print the task for the list
     */
    public void print() {
        if (this.completed) {
            System.out.print("[X] ");
        } else {
            System.out.print("[ ] ");
        }
        System.out.println(this.name);
    }
}