package sahej.tasks;
import sahej.ui.*;

public class ToDo {
    protected String name;
    protected boolean isCompleted;

    public ToDo(String name) throws SahejException {
        if (name == null || name.isEmpty()) {
            throw ErrorExceptions.INVALID_TODO_INPUT;
        }
        this.name = name;
        this.isCompleted = false;
    }

    public ToDo() {
        this.isCompleted = false;
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
        return this.isCompleted;
    }

    /**
     * Change status of task
     *
     * @param completed
     */
    public void setCompleted(boolean completed) {
        this.isCompleted = completed;
    }

    /**
     * Print the task for the list
     */
    public String toString() {
        if (this.isCompleted) {
            return "[X][T] " + this.name;
        } else {
            return "[ ][T] " + this.name;
        }
    }
}