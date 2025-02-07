import java.util.Scanner;

import main.java.ToDo;
import main.java.Deadline;
import main.java.Event;

public class Sahej {
    public static final String LIST_COMMAND = "list";
    public static final String TODO_COMMAND = "todo ";
    public static final String DEADLINE_COMMAND = "deadline ";
    public static final String EVENT_COMMAND = "event ";
    public static final String MARK_COMMAND = "mark ";
    public static final String UNMARK_COMMAND = "unmark ";
    public static final String BYE_COMMAND = "bye";
    public static final String HORIZONTAL_LINE = "\t____________________________________________________________";
    public static final String ERROR_MESSAGE = "\tInvalid input. Please try again.";

    public static int getNumber(String input) {
        try {
            int num = Integer.parseInt(input.trim());
            return num;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void parseDeadline(String input, main.java.ToDoList list) {
        input = input.substring(8).trim();
        String[] split = input.split("/by");
        if (split.length != 2) {
            System.out.println("\tInvalid input. Please try again.");
            return;
        }
        list.add(new Deadline(split[0].trim(), split[1].trim()));
    }

    public static void parseEvent(String input, main.java.ToDoList list) {
        input = input.substring(5).trim();
        String[] split = input.split("/from");
        if (split.length != 2) {
            System.out.println(ERROR_MESSAGE);
            return;
        }
        String name = split[0].trim();
        String[] split2 = split[1].split("/to");
        if (split2.length > 2) {
            System.out.println(ERROR_MESSAGE);
            return;
        } else if (split2.length == 2) {
            list.add(new Event(name, split2[0].trim(), split2[1].trim()));
            return;
        }
        split2 = split[0].split("/to");
        if (split2.length != 2) {
            System.out.println(ERROR_MESSAGE);
            return;
        }
        list.add(new Event(split2[0].trim(), split[1].trim(), split2[1].trim()));
    }

    public static void parseInput(String input, main.java.ToDoList list) {
        if (input.equals(LIST_COMMAND)) {
            list.printItems();
        } else if (input.startsWith(MARK_COMMAND)) {
            int num = getNumber(input.substring(4));
            list.mark(num);
        } else if (input.startsWith(UNMARK_COMMAND)) {
            int num = getNumber(input.substring(6));
            list.unmark(num);
        } else if (input.startsWith(TODO_COMMAND)) {
            input = input.substring(4).trim();
            if (input.equals("")) {
                System.out.println(ERROR_MESSAGE);
                return;
            }
            list.add(new ToDo(input));
        } else if (input.startsWith(DEADLINE_COMMAND)) {
            parseDeadline(input, list);
        } else if (input.startsWith(EVENT_COMMAND)) {
            parseEvent(input, list);
        } else {
            System.out.println(ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        System.out.println(HORIZONTAL_LINE + "\n\tHello! I'm Sahej\n\tWhat can I do for you?\n" + HORIZONTAL_LINE);
        Scanner inputScanner = new Scanner(System.in);
        String input = "";
        main.java.ToDoList list = new main.java.ToDoList();
        mainloop:
        while (true) {
            input = inputScanner.nextLine().trim(); // get trimmed user input
            System.out.println(HORIZONTAL_LINE);
            if (input.equals(BYE_COMMAND)) {
                break mainloop;
            }
            parseInput(input, list);
            System.out.println(HORIZONTAL_LINE + "\n");
        }
        System.out.println("\tBye. Hope to see you again soon!\n" + HORIZONTAL_LINE);
    }
}

