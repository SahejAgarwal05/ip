package main.java;

public class ToDoList {
    private main.java.ToDo[] tasks;
    private int count;
    private final int MAX_COUNT = 100;
    private final String INVALID_NUMBER_MESSAGE = "\tInvalid task number. Please enter a valid task number.";

    public ToDoList() {
        this.count = 0;
        this.tasks = new main.java.ToDo[this.MAX_COUNT];
    }

    /**
     * Adds task to the list if there are 99 or less items
     * if there are 100 items prints List is full cannot store more than 100 items
     *
     * @param todo item to be added to the list
     */
    public void add(ToDo todo) {
        if (this.count == this.MAX_COUNT) {
            System.out.println("\tList is full cannot store more than 100 items");
        } else {
            this.tasks[this.count] = todo;
            this.count++;
            System.out.println("\tAdded");
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
    public void mark(int taskNo) {
        if (this.count == 0 || taskNo < 0 || taskNo > this.count) {
            System.out.println(INVALID_NUMBER_MESSAGE);
        } else {
            tasks[taskNo - 1].setCompleted(true);
            System.out.println("\tMarked " + taskNo + " completed");
        }
    }
    /**
     * Mark item to incomplet
     * @param taskNo index of the item to be marked incomplete
     */
    public void unmark(int taskNo) {
        if (this.count == 0 || taskNo <= 0 || taskNo > this.count) {
            System.out.println(INVALID_NUMBER_MESSAGE);
        } else {
            tasks[taskNo - 1].setCompleted(false);
            System.out.println("\tMarked " + taskNo + " incomplete");
        }
    }
}


