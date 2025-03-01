package sahej.tasks;
import sahej.ui.*;

/**
 * Represents an event task with a start and end time.
 */
public class Event extends ToDo {
    private String from;
    private String to;
    /**
     * Constructs an Event task with a specified name, start time, and end time.
     *
     * @param name The name of the event.
     * @param from The start time of the event.
     * @param to The end time of the event.
     * @throws SahejException If any of the input parameters are null or empty.
     */
    public Event(String name, String from, String to) throws SahejException {
        if (from == null || to == null || from.equals("") || to.equals("")|| name.equals("") || name == null) {
            throw ErrorExceptions.INVALID_EVENT_INPUT;
        }
        this.from = from;
        this.to = to;
        this.name = name;
    }
    /**
     * Retrieves the start time of the event.
     *
     * @return The start time of the event.
     */
    public String getFrom() {
        return from;
    }
    /**
     * Updates the start time of the event.
     *
     * @param from The new start time of the event.
     */
    public String getTo() {
        return to;
    }
    /**
     * Updates the end time of the event.
     *
     * @param to The new end time of the event.
     */
    public void setFrom(String from) {
        this.from = from;
    }
    /**
     * Returns a string representation of the Event task.
     *
     * @return A formatted string displaying the task status, type, name, start time, and end time.
     */
    public void setTo(String to) {
        this.to = to;
    }
    /**
     * Returns a string representation of the Event task.
     *
     * @return A formatted string displaying the task status, type, name, start time, and end time.
     */
    @Override
    public String toString() {
        if (this.isCompleted) {
            return "[X][E] " + this.name + " (from: " + this.from + " to: " + this.to + ")";
        } else {
            return "[ ][E] " + this.name + " (from: " + this.from + " to: " + this.to + ")";
        }
    }

    /**
     * Formats the Event task as a string suitable for saving to a file.
     *
     * @return A formatted string representing the Event task for storage.
     */
    @Override
    public String saveFormat(){
        String saveString = "E|";
        if (this.isCompleted) {
            saveString += "X|";
        } else {
            saveString += " |";
        }
        saveString += this.name + "|";
        saveString += this.from + "|" + this.to;
        return saveString  + "\n";
    }
}