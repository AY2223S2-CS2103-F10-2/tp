package seedu.address.logic.commands.delete;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.MultipleEventsParser;
import seedu.address.model.Model;
import seedu.address.model.module.ModuleCode;

/**
 * Deletes multiple modules identified using their resepective module codes
 * If one or more of the modules do not exist, nothing happens.
 */
public class DeleteMultipleModulesCommand extends DeleteCommand implements MultipleEventsParser {

    public static final String MESSAGE_SUCCESS = "%1$s Modules deleted ( %2$s )";
    private final ArrayList<ModuleCode> targetModuleCodes;

    /**
     * Creates an executable Command that deletes multiple modules of {@code moduleCodes}
     * @param moduleCode
     */
    public DeleteMultipleModulesCommand(ModuleCode ... moduleCodes) {
        ArrayList<ModuleCode> moduleCodesArr = new ArrayList<ModuleCode>();
        for (ModuleCode each: moduleCodes) {
            moduleCodesArr.add(each);
        }

        this.targetModuleCodes = moduleCodesArr;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        ArrayList<ModuleCode> invalidModuleCodes = new ArrayList<>();
        for (ModuleCode each: this.targetModuleCodes) {
            if (!model.hasModule(each)) {
                invalidModuleCodes.add(each);
            }
        }

        if (invalidModuleCodes.size() == 0) {
            for (ModuleCode each: this.targetModuleCodes) {
                DeleteModuleCommand dmc = new DeleteModuleCommand(each);
                dmc.execute(model);
            }

            return new CommandResult(String.format(MESSAGE_SUCCESS,
                    targetModuleCodes.size(),
                    MultipleEventsParser.convertArrayListToString(targetModuleCodes)));
        } else {
            throw new CommandException(String.format(
                    (invalidModuleCodes.size() == 1
                            ? Messages.MESSAGE_MODULE_DOES_NOT_EXIST
                            : Messages.MESSAGE_MODULES_DONT_EXIST),
                    MultipleEventsParser.convertArrayListToString(invalidModuleCodes)));
        }
    }
}