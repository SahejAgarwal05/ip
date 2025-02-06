package main.java;

public class ToDo {
    protected String name;
    protected boolean completed;

    public ToDo(String name) {
        this.name = name;
        this.completed = false;
    }

    public ToDo() {
        this.completed = false;
        this.name = "";
    }

    /**
     * @return name of the task
     */
    public String getName() {
        return this.name;
    }

    /**
     * Change name of the task
     *
     * @param name new name of the task
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * check if task is completed
     *
     * @return true for completed task and false for incomplete task
     */
    public boolean isCompleted() {
        return this.completed;
    }

    /**
     * Change status of task
     *
     * @param completed
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Print the task for the list
     */
    public String toString() {
        if (this.completed) {
            return "[X][T] " + this.name;
        } else {
            return "[ ][T] " + this.name;
        }
    }
}