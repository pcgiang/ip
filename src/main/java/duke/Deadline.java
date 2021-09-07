package duke;

import duke.exception.InvalidDeadlineException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * A subclass of task that represents a deadline.
 *
 */
public class Deadline extends Task {
    private String type;
    private LocalDate deadline;

    /**
     * Constructor for Deadline class.
     *
     * @param title Name of the task to be created.
     * @param deadline Date of the deadline.
     */
    public Deadline(String title, String deadline) throws InvalidDeadlineException {
        super(title);
        type = "D";
        try {
            this.deadline = LocalDate.parse(deadline);
        } catch (DateTimeParseException e) {
            throw new InvalidDeadlineException();
        }
    }

    @Override
    public String toString() {
        String deadline = this.deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        return "[" + type + "]" + super.toString() + "(by: " + deadline + ")";
    }

    /**
     * A method that prints out details of a task.
     *
     * @return Details of task.
     */
    @Override
    public String writeTask() {
        String deadline = this.deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        return type + " | " + super.writeTask() + " | " + deadline;
    }
}
