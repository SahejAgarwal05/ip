package sahej.ui;
public final class ErrorExceptions {
    private ErrorExceptions() {}
    public static final SahejException INVALID_NUMBER_ERROR =
            new SahejException("You have not input an acceptable number. Please input an integer.");
    public static final SahejException OUT_OF_RANGE =
            new SahejException("The number you entered is out of range.");
    public static final SahejException INVALID_COMMAND =
            new SahejException("Invalid command.");
    public static final SahejException INVALID_TODO_INPUT =
            new SahejException("Please use todo <name of task>.");
    public static final SahejException INVALID_DEADLINE_INPUT =
            new SahejException("Deadline must be in format deadline <name> /by <date and time of deadline>.");
    public static final SahejException INVALID_EVENT_INPUT =
            new SahejException("Please input a valid event in format event <name>/from <from> /to <to>.");
    public static final SahejException LIST_FULL = new SahejException("List is full.");
    public static final SahejException FILE_CORRUPT = new SahejException("Storage file corrupted.");
    public static final SahejException INVALID_FIND_INPUT = new SahejException("Invalid input. Find commands needs a name to search for");
    public static final SahejException INVALID_DEADLINE_DATE = new sahej.ui.SahejException("Invsalid by date. Date must be in format YYYY-MM-DD.");
}
