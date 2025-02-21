package sahej.tasks;
import sahej.ui.*;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class ToDoList {
    private ToDo[] tasks;
    private int count;
    private final int MAX_COUNT = 100;
    private final String INVALID_NUMBER_MESSAGE = "\tInvalid task number. Please enter a valid task number.";
    private final String SAVE_FILE = "./src/main/java/sahej/data/sahej.txt";
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
    public void saveData() throws SahejException {
        try{
            FileWriter writer = new FileWriter(this.SAVE_FILE);
            for (int i = 0; i < this.count; i++) {
                writer.write(tasks[i].toSaveFormat());
            }
            writer.close();
        } catch (Exception e){
            throw ErrorExceptions.FILE_CORRUPT;
        }
    }
    public void loadData() throws SahejException {
        try{
            Path file = Paths.get("./src/main/java/sahej/data/sahej.txt");
            String fileContent;
            try {
                fileContent = Files.readString(file);
            } catch (Exception e){
                throw ErrorExceptions.OUT_OF_RANGE;
            }
            String[] lines = fileContent.split("\n");
            for (int i = 0; i < lines.length; i++) {
                String[] splits = lines[i].split("\\|");
                ToDo insert;
                switch (splits[0]){
                    case "T":
                        insert = new ToDo(splits[2]);
                        break;
                    case "D":
                        insert = new Deadline(splits[2], splits[3]);
                        break;
                    case "E":
                        insert = new Event(splits[2], splits[3], splits[4]);
                        break;
                    default:
                        throw ErrorExceptions.FILE_CORRUPT;
                }
                insert.setCompleted(splits[1].equals("X"));
                this.tasks[i] = insert;
                this.count++;
            }
        } catch (Exception e){
            if(e.equals(ErrorExceptions.OUT_OF_RANGE)){
                System.out.println("\t No data found");
            }else {
                throw ErrorExceptions.FILE_CORRUPT;
            }
        }
    }
}


