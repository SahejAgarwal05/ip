package sahej.tasks;
import sahej.ui.*;
import sahej.ui.ErrorExceptions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task with a specific deadline
 */
public class Deadline extends ToDo {
    private LocalDate by;

    /**
     * Constructor for Deadline.
     *
     * @param name The name of the task.
     * @param by The deadline date in format YYYY-MM-DD.
     * @throws SahejException If the input name or date is invalid.
     */
    public Deadline (String name, String by) throws SahejException {
        if (by == null || by.equals("") || name == null || name.equals("")) {
            throw ErrorExceptions.INVALID_DEADLINE_INPUT;
        }
        try {
            this.by = LocalDate.parse(by);
        } catch (Exception e) {
            throw ErrorExceptions.INVALID_DEADLINE_DATE;
        }
        this.name = name;
    }

    /**
     * Retrieves the deadline date.
     *
     * @return The deadline date as a LocalDate object.
     */
    public LocalDate getBy() {
        return by;
    }

    /**
     * Sets or updates the deadline date.
     *
     * @param by The new deadline date as a LocalDate object.
     */
    public void setBy(LocalDate by) {
        this.by = by;
    }

    /**
     * Returns a string representation of the Deadline task.
     *
     * @return A formatted string displaying the task status, type, name, and deadline date.
     */
    @Override
    public String toString() {
        if (this.isCompleted) {
            return "[X][D] " + this.getName() + " (by: " + this.by.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + ")";
        } else {
            return "[ ][D] " + this.getName() + " (by: " + this.by.format(DateTimeFormatter.ofPattern("MMM dd yyyy"))  + ")";
        }
    }
    /**
     * Formats the Deadline task as a string suitable for saving to a file.
     *
     * @return A formatted string representing the Deadline task for storage.
     */
    @Override
    public String saveFormat(){
        String saveString = "D|";
        if (this.isCompleted) {
            saveString += "X|";
        } else {
            saveString += " |";
        }
        saveString += this.name + "|";
        saveString += this.by.toString();
        return saveString + "\n";
    }
}