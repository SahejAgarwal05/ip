package sahej.tasks;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import sahej.ui.*;
import sahej.tasks.*;

/**
 * Manages saving and loading ToDoList data to and from a file.
 */
public class DataManager {
    private  String saveFile;
    /**
     * Constructs a DataManager with a specified save file path.
     *
     * @param saveFile The file path where task data will be saved and loaded from.
     */
    public DataManager(String saveFile) {
        this.saveFile = saveFile;
    }
    /**
     * Saves the ToDoList data
     *
     * @param list The ToDoList to be saved.
     * @throws SahejException If an error occurs while writing to the file such as file does not exist.
     */
    public void saveData(ToDoList list) throws sahej.ui.SahejException {
        try {
            FileWriter writer = new FileWriter(this.saveFile);
            writer.write(list.getSaveFormat());
            writer.close();
        } catch (Exception e) {
            throw ErrorExceptions.FILE_CORRUPT;
        }
    }
    /**
     * Loads task data from the  file into the provided ToDoList. Creates the folder and file if none exist
     *
     * @param list The ToDoList where the loaded tasks will be added.
     * @throws SahejException If an error occurs while reading from the file or processing its contents.
     */
    public void loadData(ToDoList list) throws SahejException {
        try {
            File saveFile = new File(this.saveFile);
            File saveFolder = saveFile.getParentFile();
            if (saveFolder != null && !saveFolder.exists()) { // check if the folder exists
                saveFolder.mkdirs(); // create folder if needed
                new FileOutputStream(saveFile, false).close(); // Creates a blank file
                return;
            }
            if (!saveFile.exists()) {// Ensure the file exists
                new FileOutputStream(saveFile, false).close(); // Creates a blank file
                return;
            }
            String rawData = Files.readString(Path.of(this.saveFile));
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
                    list.add(insert);
                }
            }
        } catch (Exception e) {
            throw ErrorExceptions.FILE_CORRUPT;
        }
    }
}