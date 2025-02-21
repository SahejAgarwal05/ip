package sahej.tasks;
import sahej.ui.*;
public class Event extends ToDo {
    private String from;
    private String to;

    public Event(String name, String from, String to) throws SahejException {
        if (from == null || to == null || from.equals("") || to.equals("") || name.equals("") || name == null) {
            throw ErrorExceptions.INVALID_EVENT_INPUT;
        }
        this.from = from;
        this.to = to;
        this.name = name;

    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        if (this.isCompleted) {
            return "[X][E] " + this.name + " (from: " + this.from + " to: " + this.to + ")";
        } else {
            return "[ ][E] " + this.name + " (from: " + this.from + " to: " + this.to + ")";
        }
    }
    @Override
    public String toSaveFormat() {
        String saveString = "E|";
        if (this.isCompleted) {
            saveString += "X|";
        } else {
            saveString += " |";
        }
        saveString += this.name + "|" + this.from + "|" + this.to + "\n";
        return saveString;
    }
}