import java.util.Scanner;
import sahej.tasks.*;
import sahej.ui.*;
public class Sahej {
    public static final String HORIZONTAL_LINE = "\t____________________________________________________________";
    public static final String ERROR_MESSAGE = "\tInvalid input. Please try again.";
    public static ToDoList list = new ToDoList();
    public static int getNumber(String input) throws SahejException {
        try {
            int n = Integer.parseInt(input.trim());
            return n;
        } catch (NumberFormatException e) {
            throw ErrorExceptions.INVALID_NUMBER_ERROR;
        }
    }
    public static void parseDeadline(String input) throws SahejException {
        input = input.substring(8).trim();
        String[] split = input.split("/by");
        list.add(new Deadline(split[0].trim(), split[1].trim()));
    }

    public static void parseEvent(String input) throws SahejException {
        input = input.substring(5).trim();
        String[] split = input.split("/from");
        if (split.length != 2) {
            throw ErrorExceptions.INVALID_EVENT_INPUT;
        }
        String name = split[0].trim();
        String[] split2 = split[1].split("/to");
        if (split2.length > 2) {
            throw ErrorExceptions.INVALID_EVENT_INPUT;
        } else if (split2.length == 2) {
            list.add(new Event(name, split2[0].trim(), split2[1].trim()));
            return;
        }
        split2 = split[0].split("/to");
        if (split2.length != 2) {
            throw ErrorExceptions.INVALID_EVENT_INPUT;
        }
        list.add(new Event(split2[0].trim(), split[1].trim(), split2[1].trim()));
    }

    public static void parseInput(String input) throws SahejException {
        String commnad = input.split(" ")[0].trim();
        int num;
        switch (commnad) {
        case Commands.LIST_COMMAND:
            list.printItems();
            break;
        case Commands.MARK_COMMAND:
            num = getNumber(input.substring(4));
            list.mark(num);
            break;
        case Commands.UNMARK_COMMAND:
            num = getNumber(input.substring(6));
            list.unmark(num);
            break;
        case Commands.TODO_COMMAND:
            input = input.substring(4).trim();
            list.add(new ToDo(input));
            break;
        case Commands.DEADLINE_COMMAND:
            parseDeadline(input);
            break;
        case Commands.EVENT_COMMAND:
            parseEvent(input);
            break;
        default:
            throw ErrorExceptions.INVALID_COMMAND;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(HORIZONTAL_LINE + "\n\tHello! I'm Sahej\n\tWhat can I do for you?\n" + HORIZONTAL_LINE);
        Scanner inputScanner = new Scanner(System.in);
        String input = "";
        try {
            list.loadData();
        } catch (SahejException e) {
            System.out.println(e.getMessage());
        }
        mainloop:
        while (true) {
            input = inputScanner.nextLine().trim(); // get trimmed user input
            System.out.println(HORIZONTAL_LINE);
            if (input.equals(Commands.BYE_COMMAND)) {
                try{
                list.saveData();
                } catch (SahejException e) {
                    System.out.println(e.getMessage());
                }
                break mainloop;
            }
            try {
                parseInput(input);
            }
            catch (SahejException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(HORIZONTAL_LINE + "\n");
        }
        System.out.println("\tBye. Hope to see you again soon!\n" + HORIZONTAL_LINE);
    }
}

