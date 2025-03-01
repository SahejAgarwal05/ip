package sahej.tasks;
import sahej.ui.*;
import sahej.ui.ErrorExceptions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends ToDo {
    private LocalDate by;

    public Deadline (String name, String by) throws SahejException {
        if (by == null || by.equals("") || name == null || name.equals("")) {
            throw ErrorExceptions.INVALID_DEADLINE_INPUT;
        }
        try {
            this.by = LocalDate.parse(by);
        } catch (Exception e) {
            throw ErrorExceptions.INVALID_DEADLINE_DATE.;
        }
        this.name = name;
    }

    /**
     * returns the time of the deadline
     * @return
     */
    public LocalDate getBy() {
        return by;
    }

    /**
     *alter the deadline time
     * @param by
     */
    public void setBy(LocalDate by) {
        this.by = by;
    }

    @Override
    public String toString() {
        if (this.isCompleted) {
            return "[X][D] " + this.getName() + " (by: " + this.by.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + ")";
        } else {
            return "[ ][D] " + this.getName() + " (by: " + this.by.format(DateTimeFormatter.ofPattern("MMM dd yyyy"))  + ")";
        }
    }
    /**
     * returns in String format ready to be saved
     * @return saveString
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