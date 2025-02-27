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
    /**
     *
     * Extracts the integer value
     * @param input
     * @return value
     * @throws SahejException
     */
    private  int getNumber(String input) throws SahejException {
        try {
            int n = Integer.parseInt(input.trim());
            return n;
        } catch (NumberFormatException e) {
            throw ErrorExceptions.INVALID_NUMBER_ERROR;
        }
    }

    /**
     * parses input when determined to be deadline
     * @param input
     * @throws SahejException
     */
    private void parseDeadline(String input) throws SahejException {
        input = input.substring(8).trim();
        String[] split = input.split("/by");
        list.add(new Deadline(split[0].trim(), split[1].trim()));
        ui.displayWithLines("Added");
    }

    /**
     * parses input when determined to be event
     * @param input
     * @throws SahejException
     */
    private void parseEvent(String input) throws SahejException {
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

    /**
     * Parses input in conditions when it is noe bye
     * @param input
     * @throws SahejException
     */
    public void parseAndExecuteInput(String input) throws SahejException {
        String commnad = input.split(" ")[0].trim();
        int num;
        switch (commnad) {
            case Commands.LIST_COMMAND:
                ui.displayList(list.getPrintItems());
                break;
            case Commands.MARK_COMMAND:
                num = getNumber(input.substring(4));
                list.mark(num);
                ui.displayWithLines("Marked: " + num);
                break;
            case Commands.UNMARK_COMMAND:
                num = getNumber(input.substring(6));
                list.unmark(num);
                ui.displayWithLines("Unmarked: " + num);
                break;
            case Commands.TODO_COMMAND:
                input = input.substring(4).trim();
                ToDo td = new ToDo(input);
                list.add(td);
                ui.displayWithLines("Added : " + td.toString());
                break;
            case Commands.DEADLINE_COMMAND:
                parseDeadline(input);
                break;
            case Commands.EVENT_COMMAND:
                parseEvent(input);
                break;
            case Commands.DELETE_COMMAND:
                num = getNumber(input.substring(6));
                list.delete(num);
                ui.displayWithLines("Deleted: " + num);
                break;
            default:
                throw ErrorExceptions.INVALID_COMMAND;
        }
    }
    public boolean isBye(String input) {
        return input.equals(Commands.BYE_COMMAND);
    }
}

