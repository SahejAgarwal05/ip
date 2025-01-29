package main.java;
import main.java.Task;

public class ItemsList {
    private Task[] tasks;
    private int count;

    public ItemsList() {
        this.count = 0;
        this.tasks = new Task[100];
    }

    /**
     * Adds task to the list if there are 99 or less items
     * if there are 100 items prints List is full cannot store more than 100 items
     *
     * @param task item to be added to the list
     */
    public void addItem(String task) {
        if (this.count == 100) {
            System.out.println("\tList is full cannot store more than 100 items");
        } else {
            this.tasks[this.count] = new Task(task);
            this.count++;
            System.out.println("\t" + task + " added");
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
                this.tasks[i].print();
            }
        }
    }

    public void mark(int taskNo) {
        if (this.count == 0 || taskNo < 0 || taskNo > this.count) {
            System.out.println("\tInvalid task number. Please enter a valid task number.");
        } else {
            tasks[taskNo - 1].setCompleted(true);
            System.out.println("\tMarked " + taskNo + " completed");
        }
    }

    public void unmark(int taskNo) {
        if (this.count == 0 || taskNo <= 0 || taskNo >= this.count) {
            System.out.println("\tInvalid task number. Please enter a valid task number.");
        } else {
            tasks[taskNo - 1].setCompleted(false);
            System.out.println("\tMarked " + taskNo + " incomplete");
        }
    }
}


