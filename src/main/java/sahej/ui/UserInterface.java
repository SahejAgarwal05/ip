package sahej.ui;
import sahej.ui.*;
import java.util.Scanner;
/**
 * Handles user interactions including displaying messages and receiving input.
 */
public class UserInterface {
    private  final String HORIZONTAL_LINE = "\t____________________________________________________________";
    private  Scanner scanner;
    /**
     * Constructs a UserInterface with a scanner for user input.
     */
    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }
    /**
     * Displays the welcome message to the user.
     */
    public void displayWelcomeMessage() {
        this.displayWithLines("Hello I am Sahej. How may I help you?");
    }
    /**
     * Displays a message wrapped with horizontal lines.
     *
     * @param message The message to be displayed.
     */
    public void displayWithLines(String message){
        System.out.println(HORIZONTAL_LINE);
        System.out.println("\t" + message);
        System.out.println(HORIZONTAL_LINE);
    }
    /**
     * Displays an exception message.
     *
     * @param e The exception to be displayed.
     */
    public void displayException(SahejException e) {
        displayWithLines("Error : " + e.getMessage());
    }/**
     * Displays a formatted list of tasks or an empty list message if no tasks exist.
     *
     * @param list The list of tasks to be displayed.
     * @param emptyListMessage The message to display if the list is empty.
     */
    public void displayList(String[] list, String emptyListMessage) {
        if (list.length == 0) {
            displayWithLines(emptyListMessage);
            return;
        }
        String finalList = "";
        for(String s : list){
            finalList = finalList + "\t"+ s + "\n";
        }
        finalList = finalList + "\tEND OF LIST";
        displayWithLines(finalList.substring(1));
    }
    /**
     * Retrieves user input
     *
     * @return The trimmed user input as a string.
     */
    public String getUserInput(){
        return scanner.nextLine().trim();
    }
    /**
     * Displays a goodbye message to the user.
     */
    public void displayGoodBye(){
        displayWithLines("Goodbye. Hope to see you soon!");
    }
}

