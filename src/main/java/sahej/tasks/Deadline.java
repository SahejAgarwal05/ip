package sahej.tasks;
import sahej.ui.*;
public class Deadline extends ToDo {
    private String by;

    public Deadline (String name, String by) throws SahejException {
        if (by == null || by.equals("") || name == null || name.equals("")) {
            throw ErrorExceptions.INVALID_DEADLINE_INPUT;
        }
        this.name = name;
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
        saveString += this.by;
        return saveString + "\n";
    }
}