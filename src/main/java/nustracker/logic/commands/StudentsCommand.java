package nustracker.logic.commands;

import java.util.function.Predicate;

import nustracker.logic.commands.exceptions.CommandException;
import nustracker.model.Model;
import nustracker.model.student.Student;

/**
 * Displays the students list.
 */
public class StudentsCommand extends Command {

    public static final String COMMAND_WORD = "students";
    public static final String MESSAGE_SHOW_STUDENTS_SUCCESS =
            "Here is the list of students.";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        model.updateFilteredStudentList(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return true;
            }
        });
        return new CommandResult(MESSAGE_SHOW_STUDENTS_SUCCESS, false, false, false,
                true, false);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof StudentsCommand)) {
            return false;
        }

        // state check
        return true;
    }
}

