package sahej.tasks;
import sahej.ui.*;

public class ToDoList {
    private ToDo[] tasks;
    private int count;
    private final int MAX_COUNT = 100;
    private final String INVALID_NUMBER_MESSAGE = "\tInvalid task number. Please enter a valid task number.";

    public ToDoList() {
        this.count = 0;
        this.tasks = new ToDo[this.MAX_COUNT];
    }

    /**
     * Adds task to the list if there are 99 or less items
     * if there are 100 items prints List is full cannot store more than 100 items
     *
     * @param todo item to be added to the list
     */
    public void add(ToDo todo) throws SahejException {
        try {
            this.tasks[this.count] = todo;
            this.count++;
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
        if (this.count == 0) {
            System.out.println("\tList is empty");
        } else {
            for (int i = 0; i < this.count; i++) {
                System.out.print("\t" + (i + 1) + ". ");
                System.out.println(this.tasks[i].toString());
            }
        }
    }

    /**
     * Mark item to completed
     * @param taskNo index of the item to be marked complete
     */
    public void mark(int taskNo) throws SahejException {
        try {
            tasks[taskNo - 1].setCompleted(true);
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
            tasks[taskNo - 1].setCompleted(false);
            System.out.println("\tUnmarked");
        } catch (Exception e){
            throw ErrorExceptions.OUT_OF_RANGE;
        }
    }
}


