package main.java;

public class Deadline extends ToDo {
    private String by;

    public Deadline(String name, String by) {
        super(name);
        this.by = by;
    }

    /**
     * returns the time of the deadline
     * @return
     */
    public String getBy() {
        return by;
    }

    /**
     *alter the deadline time
     * @param by
     */
    public void setBy(String by) {
        this.by = by;
    }

    @Override
    public String toString() {
        if (this.isCompleted) {
            return "[X][D] " + this.getName() + " (by: " + this.by + ")";
        } else {
            return "[ ][D] " + this.getName() + " (by: " + this.by + ")";
        }
    }
}