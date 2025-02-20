package sahej.tasks;
import sahej.ui.*;

import java.util.ArrayList;

public class ToDoList {
    private ArrayList<ToDo> tasks;

    public ToDoList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds task to the list if there are 99 or less items
     * if there are 100 items prints List is full cannot store more than 100 items
     *
     * @param todo item to be added to the list
     */
    public void add(ToDo todo) throws SahejException {
        try {
            this.tasks.add(todo);
            System.out.println("\tAdded");
        } catch(Exception e) {
            throw ErrorExceptions.LIST_FULL;
        }
    }

    /**
     * Prints all items with serial numbers
     * if there are no items prints List is empty
     */
    public void printItems() {
        if (this.tasks.isEmpty()) {
            System.out.println("\tList is empty");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.print("\t" + (i + 1) + ". ");
                System.out.println(this.tasks.get(i).toString());
            }
        }
    }

    /**
     * Mark item to completed
     * @param taskNo index of the item to be marked complete
     */
    public void mark(int taskNo) throws SahejException {
        try {
            this.tasks.get(taskNo - 1).setCompleted(true);
            System.out.println("\tMarked task");
        } catch (Exception e) {
            throw ErrorExceptions.OUT_OF_RANGE;
        }
    }
    /**
     * Mark item to incomplete
     * @param taskNo index of the item to be marked incomplete
     */
    public void unmark(int taskNo) throws SahejException {
        try{
            this.tasks.get(taskNo - 1).setCompleted(false);
            System.out.println("\tUnmarked");
        } catch (Exception e){
            throw ErrorExceptions.OUT_OF_RANGE;
        }
    }

    public void delete(int taskNo) throws SahejException {
        try {
            tasks.remove(taskNo - 1);
            System.out.println("\tDeleted task");
        } catch (Exception e) {
            throw ErrorExceptions.OUT_OF_RANGE;
        }
    }
}


