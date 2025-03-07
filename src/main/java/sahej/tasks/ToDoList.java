package sahej.tasks;
import sahej.ui.*;
import java.util.ArrayList;
import sahej.tasks.*;
import sahej.ui.ErrorExceptions;

/**
 * Manages a list of  tasks
 */
public class ToDoList {
    private ArrayList<ToDo> tasks;
    private final String SAVEFILE = "./data/sahej.txt";
    /**
     * Constructs an empty ToDoList.
     */
    public ToDoList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a task to the list.
     *
     * @param todo The task to be added.
     * @throws SahejException If the list is full or an error occurs while adding.
     */
    public void add(ToDo todo) throws SahejException {
        try {
            this.tasks.add(todo);
        } catch(Exception e) {
            throw ErrorExceptions.LIST_FULL;
        }
    }

    /**
     * Retrieves all tasks in a formatted string array for display.
     *
     * @return A list of formatted task strings.
     * @throws SahejException If an error occurs while retrieving the tasks.
     */
    public String[] getPrintItems() throws SahejException {
        String[] finalList = new String[this.tasks.size()];
        for (int i = 0; i < tasks.size(); i++) {
            finalList[i] = (i + 1) + ". " + this.tasks.get(i).toString();
        }
        return finalList;
    }

    /**
     * Sets a task as complete
     *
     * @param taskNo The index of the task to be marked as completed.
     * @throws SahejException If the task number is out of range.
     */
    public void mark(int taskNo) throws SahejException {
        try {
            this.tasks.get(taskNo - 1).setCompleted(true);
        } catch (Exception e) {
            throw ErrorExceptions.OUT_OF_RANGE;
        }
    }

    /**
     * Sets a task as incomplete
     *
     * @param taskNo The index of the task to be unmarked.
     * @throws SahejException If the task number is out of range.
     */
    public void unmark(int taskNo) throws SahejException {
        try{
            this.tasks.get(taskNo - 1).setCompleted(false);
        } catch (Exception e){
            throw ErrorExceptions.OUT_OF_RANGE;
        }
    }

    /**
     * Formats the task list for saving.
     *
     * @return A formatted string representation of all tasks for storage.
     */
    public String getSaveFormat() {
        String finalSave = "";
        for (int i = 0; i < this.tasks.size(); i++) {
            finalSave = finalSave + tasks.get(i).saveFormat() + '\n';
        }
        return finalSave;
    }
    /**
     * Deletes a task from the list.
     *
     * @param taskNo The index of the task to be deleted.
     * @throws SahejException If the task number is out of range.
     */
    public void delete(int taskNo) throws SahejException {
        try {
            tasks.remove(taskNo - 1);
        } catch (Exception e) {
            throw ErrorExceptions.OUT_OF_RANGE;
        }
    }
    /**
     * Searches for tasks that have name as a part of their name. This function is not case sensitive,
     *
     * @param name The keyword to search for in task names.
     * @return A list of formatted task strings that match the search query.
     * @throws SahejException If the search query is empty or invalid.
     */
    public String[] searchByName(String name) throws SahejException {
        if (name.trim().isEmpty()){
            throw ErrorExceptions.INVALID_FIND_INPUT;
        }
        ArrayList<String> finalList = new ArrayList<>();
        ToDo current;
        for (int i = 0; i < this.tasks.size(); i++) {
            current = tasks.get(i);
            if (current.getName().toLowerCase().contains(name.trim().toLowerCase())){
                finalList.add(current.toString());
            }
        }
        return finalList.toArray(new String[finalList.size()]);
    }
}



