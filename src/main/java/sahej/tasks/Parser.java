package sahej.tasks;
import sahej.tasks.*;
import sahej.ui.*;

public class Parser {
    private  ToDoList list;
    private  UserInterface ui;
    public Parser(UserInterface ui, ToDoList list) {
        this.ui = ui;
        this.list = list;
    }
    private  int getNumber(String input) throws SahejException {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw ErrorExceptions.INVALID_NUMBER_ERROR;
        }
    }
    private void executeDeadline(String input) throws SahejException {
        input = input.substring(8).trim();
        String[] split = input.split("/by");
        list.add(new Deadline(split[0].trim(), split[1].trim()));
        ui.displayWithLines("Added");
    }
    private void executeEvent(String input) throws SahejException {
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
            Event event = new Event(split2[0].trim(), split[1].trim(), split2[1].trim());
            list.add(event);
            ui.displayWithLines("Added : " + event.toString());
            return;
        }
        split2 = split[0].split("/to");
        if (split2.length != 2) {
            throw ErrorExceptions.INVALID_EVENT_INPUT;
        }
        Event event = new Event(split2[0].trim(), split[1].trim(), split2[1].trim());
        list.add(event);
        ui.displayWithLines("Added : " + event.toString());
    }
    private void executeToDo(String input) throws SahejException {
        input = input.substring(4).trim();
        ToDo td = new ToDo(input);
        list.add(td);
        ui.displayWithLines("Added : " + td.toString());
    }
    private void executeMark(String input) throws SahejException{
        int num = getNumber(input.substring(4));
        list.mark(num);
        ui.displayWithLines("Marked: " + num);
    }
    private void executeUnmark(String input) throws SahejException{
        int num = getNumber(input.substring(6));
        list.unmark(num);
        ui.displayWithLines("Unmarked: " + num);
    }
    private void executeDelete(String input) throws SahejException{
        int num = getNumber(input.substring(6));
        list.delete(num);
        ui.displayWithLines("Deleted: " + num);
    }
    /**
     * Parses and executes user input commands except for bye
     *
     * @param input The user input command.
     * @throws SahejException If the command is invalid.
     */
    public void parseAndExecuteInput(String input) throws SahejException {
        String commnad = input.split(" ")[0].trim();
        int num;
        switch (commnad) {
            case Commands.LIST_COMMAND:
                ui.displayList(list.getPrintItems(), "List is currently empty.");
                break;
            case Commands.MARK_COMMAND:
                executeMark(input);
                break;
            case Commands.UNMARK_COMMAND:
                executeUnmark(input);
                break;
            case Commands.TODO_COMMAND:
                executeToDo(input);
                break;
            case Commands.DEADLINE_COMMAND:
                executeDeadline(input);
                break;
            case Commands.EVENT_COMMAND:
                executeEvent(input);
                break;
            case Commands.DELETE_COMMAND:
                executeDelete(input);
                break;
            case Commands.FIND_COMMAND:
                input = input.substring(4).trim();
                ui.displayList(list.searchByName(input), "No Matches Found.");
                break;
            default:
                throw ErrorExceptions.INVALID_COMMAND;
        }
    }
    /**
     * Checks if the given input is a "bye" command.
     *
     * @param input The user input.
     * @return True if the input is a "bye" command, false otherwise.
     */
    public boolean isBye(String input) {
        return input.equals(Commands.BYE_COMMAND);
    }
}

