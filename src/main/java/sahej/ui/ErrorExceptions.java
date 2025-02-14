package sahej.ui;
public final class ErrorExceptions {
    private ErrorExceptions() {}
    public static final SahejException INVALID_NUMBER_ERROR =
            new SahejException("\tYou have not input an acceptable number. Please input an integer.");
    public static final SahejException OUT_OF_RANGE =
            new SahejException("\tThe number you entered is out of range.");
    public static final SahejException INVALID_COMMAND =
            new SahejException("\tInvalid command.");
    public static final SahejException INVALID_TODO_INPUT =
            new SahejException("\tPlease use todo <name of task>.");
    public static final SahejException INVALID_DEADLINE_INPUT =
            new SahejException("\tDeadline must be in format deadline <name> /by <date and time of deadline>.");
    public static final SahejException INVALID_EVENT_INPUT =
            new SahejException("\tPlease input a valid event in format event <name>/from <from> /to <to>.");
    public static final SahejException LIST_FULL = new SahejException("\tList is full.");
}
