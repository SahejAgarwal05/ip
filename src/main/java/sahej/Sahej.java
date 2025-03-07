import sahej.tasks.*;
import sahej.ui.*;

/**
 * Main class for the Sahej chatbot
 */
public class Sahej {
    private static final String SAVEFILE = "./data/sahej.txt";
    private  ToDoList list;
    private  UserInterface ui;
    private  DataManager storageManager;
    private Parser parser;
    /**
     * Constructs the Sahej chatbot
     */
    public Sahej(String fileName) {
        list = new ToDoList();
        ui = new UserInterface();
        storageManager = new DataManager(fileName);
        parser = new Parser(ui, list);

    }
    /**
     * Initializes the chatbot by displaying a welcome message and loading stored tasks.
     */
    public void initialize() {
        ui.displayWelcomeMessage();
        try {
            storageManager.loadData(list);
        } catch (SahejException e){
            ui.displayException(e);
        }
    }
    /**
     * Runs the chat loop until the user inputs bye.
     */
    public void runChat(){
        String input = ui.getUserInput();
        while(!parser.isBye(input)){
            try {
                parser.parseAndExecuteInput(input);
            } catch (SahejException e){
                ui.displayException(e);
            }
            input = ui.getUserInput();
        }
    }
    /**
     * Ends the chat, saves data, and displays a goodbye message.
     */
    public void endChat() {
        ui.displayGoodBye();
        try {
            storageManager.saveData(list);
        } catch (SahejException e){
            ui.displayException(e);
        }
    }
    public static void main(String[] args) {
        Sahej sahej = new Sahej(SAVEFILE);
        sahej.initialize();
        sahej.runChat();
        sahej.endChat();
    }
}

