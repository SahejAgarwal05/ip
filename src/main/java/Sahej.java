import java.util.Scanner;

import main.java.ToDo;
import main.java.Deadline;
import main.java.Event;

public class Sahej {
    public static int getNumber(String input) {
        try {
            int num = Integer.parseInt(input.trim());
            return num;
        } catch (NumberFormatException e) {
            System.out.println("\tInvalid number. Please try again.");
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
            System.out.println("\tInvalid input. Please try again.");
            return;
        }
        String name = split[0].trim();
        String[] split2 = split[1].split("/to");
        if (split2.length > 2) {
            System.out.println("\tInvalid input. Please try again.");
            return;
        } else if (split2.length == 2) {
            list.add(new Event(name, split2[0].trim(), split2[1].trim()));
            return;
        }
        split2 = split[0].split("/to");
        if (split2.length != 2) {
            System.out.println("\tInvalid input. Please try again.");
            return;
        }
        list.add(new Event(split2[0].trim(), split[0].trim(), split2[1].trim()));
    }

    public static void parseInput(String input, main.java.ToDoList list) {
        if (input.equals("list")) {
            list.printItems();
        } else if (input.startsWith("mark ")) {
            int num = getNumber(input.substring(4));
            list.mark(num);
        } else if (input.startsWith("unmark ")) {
            int num = getNumber(input.substring(6));
            list.unmark(num);
        } else if (input.startsWith("todo ")) {
            input = input.substring(4).trim();
            if (input.equals("")) {
                System.out.println("\tInvalid input. Please try again.");
                return;
            }
            list.add(new ToDo(input));
        } else if (input.startsWith("deadline ")) {
            parseDeadline(input, list);
        } else if (input.startsWith("event ")) {
            parseEvent(input, list);
        } else {
            System.out.println("\tInvalid input. Please try again.");
        }
    }

    public static void main(String[] args) {
        String horizontalLine = "\t____________________________________________________________";
        System.out.println(horizontalLine + "\n\tHello! I'm Sahej\n\tWhat can I do for you?\n" + horizontalLine);
        Scanner inputScanner = new Scanner(System.in);
        String input = "";
        main.java.ToDoList list = new main.java.ToDoList();
        mainloop:
        while (true) {
            input = inputScanner.nextLine().trim(); // get trimmed user input
            System.out.println(horizontalLine);
            if (input.equals("bye")) {
                break mainloop;
            }
            parseInput(input, list);
            System.out.println(horizontalLine + "\n");
        }
        System.out.println("\tBye. Hope to see you again soon!\n" + horizontalLine);
    }
}

