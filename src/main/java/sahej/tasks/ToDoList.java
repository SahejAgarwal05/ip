package sahej.tasks;
import sahej.ui.*;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;

public class ToDoList {
    private ArrayList<ToDo> tasks;
    private final int MAX_COUNT = 100;
    private final String INVALID_NUMBER_MESSAGE = "\tInvalid task number. Please enter a valid task number.";
    private final String SAVEFILE = "./src/main/java/sahej/data/sahej.txt";
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
    public void saveData() throws Exception {
        try {
            FileWriter writer = new FileWriter(this.SAVEFILE);
            for (int i = 0; i < tasks.size(); i++) {
                writer.write(tasks.get(i).saveFormat());
            }
            writer.close();
        } catch (Exception e) {
            throw ErrorExceptions.FILE_CORRUPT;
        }
    }
    public void loadData() throws Exception {
        try {
            String rawData = Files.readString(Path.of(this.SAVEFILE));
            String[] lines = rawData.split("\n");
            for (int i = 0; i < lines.length; i++) {
                lines[i] = lines[i].trim();
                String[] splits = lines[i].split("\\|");
                ToDo insert = null;
                switch (splits[0]) {
                    case "T":
                        insert = new ToDo(splits[2]);
                        break;
                    case "E":
                        insert = new Event(splits[2], splits[3], splits[4]);
                        break;
                    case "D":
                        insert = new Deadline(splits[2], splits[3]);
                        break;
                    default:
                        insert = null;
                }
                if (insert != null) {
                    insert.setCompleted(splits[1].equals("X"));
                    this.tasks.add(insert);
                }
            }
        } catch (Exception e) {
            throw ErrorExceptions.FILE_CORRUPT;
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


