package sahej.tasks;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import sahej.ui.*;
import sahej.tasks.*;
public class DataManager {
    private  String saveFile;

    public DataManager(String saveFile) {
        this.saveFile = saveFile;
    }
    public void saveData(ToDoList list) throws sahej.ui.SahejException {
        try {
            FileWriter writer = new FileWriter(this.saveFile);
            writer.write(list.getSaveFormat());
            writer.close();
        } catch (Exception e) {
            throw ErrorExceptions.FILE_CORRUPT;
        }
    }
    public void loadData(ToDoList list) throws SahejException {
        try {
            File saveFile = new File(this.saveFile);
            File saveFolder = saveFile.getParentFile();
            if (saveFolder != null && !saveFolder.exists()) {
                saveFolder.mkdirs();
            }
            // Ensure the file exists
            if (!saveFile.exists()) {
                new FileOutputStream(saveFile, false).close(); // Creates a blank file
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