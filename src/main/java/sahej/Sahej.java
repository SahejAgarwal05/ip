import sahej.tasks.*;
import sahej.ui.*;

public class Sahej {
    private static final String SAVEFILE = "./data/sahej.txt";
    private  ToDoList list;
    private  UserInterface ui;
    private  DataManager storageManager;
    private Parser parser;
    public Sahej() {
        list = new ToDoList();
        ui = new UserInterface();
        storageManager = new DataManager(SAVEFILE);
        parser = new Parser(ui, list);

    }
    public void initialize() {
        ui.displayWelcomeMessage();
        try {
            storageManager.loadData(list);
        } catch (SahejException e){
            ui.displayException(e);
        }
    }
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
    public void endChat() {
        ui.displayGoodBye();
        try {
            storageManager.saveData(list);
        } catch (SahejException e){
            ui.displayException(e);
        }
    }
    public static void main(String[] args) {
        Sahej sahej = new Sahej();
        sahej.initialize();
        sahej.runChat();
        sahej.endChat();
    }
}

