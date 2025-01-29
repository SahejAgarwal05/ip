import java.util.Scanner;
import main.java.ItemsList;

public class Sahej {
    public static void main(String[] args) {
        String horizontalLine = "\t____________________________________________________________";
        System.out.println(horizontalLine + "\n\tHello! I'm Sahej\n\tWhat can I do for you?\n" + horizontalLine);
        Scanner inputScanner = new Scanner(System.in);
        String input = "";
        ItemsList list = new ItemsList();
        mainLoop:
        while (true) {
            input = inputScanner.nextLine().trim(); // get trimmed user input
            System.out.println(horizontalLine);
            switch (input) {
                case "bye":
                    break mainLoop;
                case "list":
                    list.printItems();
                    break;
                default:
                    if (input.startsWith("mark ")) {
                        try {
                            int num = Integer.parseInt(input.substring("mark ".length()));
                            list.mark(num);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number. Please try again.");
                        }
                    } else if (input.startsWith("unmark ")) {
                        try {
                            int num = Integer.parseInt(input.substring("unmark ".length()));
                            list.unmark(num);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number. Please try again.");
                        }
                    } else {
                        list.addItem(input);
                    }
            }
            System.out.println(horizontalLine + "\n");
        }
        System.out.println("\tBye. Hope to see you again soon!\n" + horizontalLine);
    }
}

