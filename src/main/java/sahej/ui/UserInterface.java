package sahej.ui;
import sahej.ui.*;
import java.util.Scanner;

public class UserInterface {
    private  final String HORIZONTAL_LINE = "\t____________________________________________________________";
    private  Scanner scanner;
    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }
    public void displayWelcomeMessage() {
        System.out.println(HORIZONTAL_LINE + "\n\tHello! I'm Sahej\n\tWhat can I do for you?\n" + HORIZONTAL_LINE);
    }
    public void displayWithLines(String message){
        System.out.println(HORIZONTAL_LINE);
        System.out.println("\t" + message);
        System.out.println(HORIZONTAL_LINE);
    }
    public void displayException(SahejException e) {
        displayWithLines("Error : " + e.getMessage());
    }
    public void displayList(String[] list){
        String finalList = "";
        for(String s : list){
            finalList = finalList + "\t"+ s + "\n";
        }
        finalList = finalList + "\tEND OF LIST";
        displayWithLines(finalList.substring(1));
    }
    public String getUserInput(){
        return scanner.nextLine().trim();
    }
    public void displayGoodBye(){
        displayWithLines("Goodbye");
    }
}

