package sahej.tasks;
import sahej.ui.*;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;


public class ToDoList {
    private ArrayList<ToDo> tasks;
    private final String SAVEFILE = "./data/sahej.txt";
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
        } catch(Exception e) {
            throw ErrorExceptions.LIST_FULL;
        }
    }

    /**
     * Returns a list of all list items converted to String
     */
    public String[] getPrintItems() throws SahejException {
        if (this.tasks.isEmpty()) {
            throw ErrorExceptions.LIST_EMPTY;
        }
        String[] finalList = new String[this.tasks.size()];
        for (int i = 0; i < tasks.size(); i++) {
            finalList[i] = (i + 1) + ". " + this.tasks.get(i).toString();
        }
        return finalList;
    }

    /**
     * Mark item to completed
     * @param taskNo index of the item to be marked complete
     * @return markMessage
     */
    public void mark(int taskNo) throws SahejException {
        try {
            this.tasks.get(taskNo - 1).setCompleted(true);
        } catch (Exception e) {
            throw ErrorExceptions.OUT_OF_RANGE;
        }
    }

    /**
     * Unmark TaskNo
     * @param taskNo
     * @throws SahejException
     */
    public void unmark(int taskNo) throws SahejException {
        try{
            this.tasks.get(taskNo - 1).setCompleted(false);
        } catch (Exception e){
            throw ErrorExceptions.OUT_OF_RANGE;
        }
    }


    public String getSaveFormat() {
        String finalSave = "";
        for (int i = 0; i < this.tasks.size(); i++) {
            finalSave = finalSave + tasks.get(i).saveFormat() + '\n';
        }
        return finalSave;
    }

    /**
     * Function to Load Data
     * @throws Exception
     */
    public void loadData() throws Exception {
        try {
            File saveFile = new File(this.SAVEFILE);
            File saveFolder = saveFile.getParentFile();
            if (saveFolder != null && !saveFolder.exists()) {
                saveFolder.mkdirs();
            }
            // Ensure the file exists
            if (!saveFile.exists()) {
                new FileOutputStream(saveFile, false).close(); // Creates a blank file
            }
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
            this.tasks.clear();
            throw ErrorExceptions.FILE_CORRUPT;
        }
    }

    /**
     *Function to delete taskNo
     * @param taskNo
     * @throws SahejException
     *
     *
     */
    public void delete(int taskNo) throws SahejException {
        try {
            tasks.remove(taskNo - 1);
        } catch (Exception e) {
            throw ErrorExceptions.OUT_OF_RANGE;
        }
    }
}



