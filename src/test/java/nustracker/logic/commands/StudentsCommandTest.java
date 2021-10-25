package nustracker.logic.commands;

import org.junit.jupiter.api.Test;

import nustracker.model.Model;
import nustracker.model.ModelManager;

class StudentsCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    void execute_events_success() {
        CommandResult expectedCommandResult = new CommandResult(StudentsCommand.MESSAGE_SHOW_STUDENTS_SUCCESS,
                false, false, false, true, false);
        CommandTestUtil.assertCommandSuccess(new StudentsCommand(), model, expectedCommandResult, expectedModel);
    }

}
