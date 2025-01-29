import java.util.Scanner;
import main.java.itemsList;

public class Sahej {
    public static void main(String[] args) {
        String horizontalLine = "\t____________________________________________________________";
        System.out.println(horizontalLine+"\n\tHello! I'm Sahej\n\tWhat can I do for you?\n"+horizontalLine);
        Scanner inputScanner = new Scanner(System.in);
        String input = "";
        itemsList list = new itemsList();
        while(true){
            input = inputScanner.nextLine().trim(); // get trimmed user input
            System.out.println(horizontalLine);
            if (input.equals("bye")){
                break;
            } else if (input.equals("list")) {
                list.printItems();
            }
            else{
                list.addItem(input);
            }
            System.out.println(horizontalLine + "\n");
        }
        System.out.println("\tBye. Hope to see you again soon!\n" + horizontalLine);
    }
}

