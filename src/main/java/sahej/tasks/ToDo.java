package sahej.tasks;
import sahej.ui.*;

/**
 * Represents a basic ToDo task with a name and completion status.
 */
public class ToDo {
    protected String name;
    protected boolean isCompleted;
    /**
     * Constructs a ToDo task with a specified name.
     *
     * @param name The name of the task.
     * @throws SahejException If the name is null or empty.
     */
    public ToDo(String name) throws SahejException {
        if (name == null || name.isEmpty()) {
            throw ErrorExceptions.INVALID_TODO_INPUT;
        }
        this.name = name;
        this.isCompleted = false;
    }

    /**
     * Constructs an empty ToDo task with default values.
     */
    public ToDo() {
        this.isCompleted = false;
        this.name = "";
    }

    /**
     * Retrieves the name of the task.
     *
     * @return The name of the task.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Updates the name of the task.
     *
     * @param name The new name of the task.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks if the task is completed.
     *
     * @return True if the task is completed, false otherwise.
     */
    public boolean isCompleted() {
        return this.isCompleted;
    }

    /**
     * Updates the completion status of the task.
     *
     * @param completed The new completion status of the task.
     */
    public void setCompleted(boolean completed) {
        this.isCompleted = completed;
    }

    /**
     * Returns a string representation of the ToDo task.
     *
     * @return A formatted string displaying the task status and name.
     */
    public String toString() {
        if (this.isCompleted) {
            return "[X][T] " + this.name;
        } else {
            return "[ ][T] " + this.name;
        }
    }

    /**
     * Formats the ToDo task as a string suitable for saving to a file.
     *
     * @return A formatted string representing the ToDo task for storage.
     */
    public String saveFormat(){
        String saveString = "T|";
        if(this.isCompleted){
            saveString += "X|";
        } else {
            saveString += " |";
        }
        saveString += this.name;
        return saveString  + "\n";
    }
}