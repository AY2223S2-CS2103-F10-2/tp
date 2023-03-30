package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import static seedu.address.logic.parser.CliSyntax.PREFIX_MODULE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.module.ModuleCode;

/**
 * import modules from archive.
 */

public class ImportCommand extends Command {
    public static final String COMMAND_WORD = "import";
    //TODO: CHANGE THIS

    public static final String MESSAGE_USAGE = "\n" + COMMAND_WORD + ":\n"
            + "(1) Import all modules in archive file\n"
            + "Parameter: "
            + "{file_name}\n"
            + "Example: " + COMMAND_WORD + " hello.json\n\n"
            + "(2) Import specific modules in archive file, no similar modules in Le Tracker\n"
            + "Parameter: "
            + "{file_name} "
            + PREFIX_MODULE + " {module_1}[, {module_2}[, ...]]\n"
            + "Example: " + COMMAND_WORD + " hello.json /mod EG2310, EG1311 \n\n"
            + "(2) Import specific modules in archive file, overwrite similar modules in Le Tracker\n"
            + "Parameter: "
            + "{file_name} "
            + PREFIX_MODULE + " {module_1}[, {module_2}[, ...]]\n"
            + "Example: " + COMMAND_WORD + " hello.json /mod EG2310, EG1311 /overwrite true \n\n";

    public static final String MESSAGE_SUCCESS = "Modules %1$s imported to Le Tracker";

    private final String fileName;
    private Set<ModuleCode> moduleCodeSet;
    private final boolean isOverwritingExistingModule;
    private final boolean isImportingAllModules;

    /**
     * Creates an ImportCommand to import modules from archive file into Le Tracker
     */

    public ImportCommand(String fileName, Set<ModuleCode> moduleCodeSet,
                         boolean isOverwritingExistingModule, boolean isImportingAllModules) {
        this.fileName = fileName;
        this.moduleCodeSet = moduleCodeSet;
        this.isOverwritingExistingModule = isOverwritingExistingModule;
        this.isImportingAllModules = isImportingAllModules;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        Path archivePath = Paths.get("data", fileName);

        List<String> moduleCodeList = moduleCodeSet.stream()
                .map(moduleCode -> moduleCode.code).collect(Collectors.toList());

        return new CommandResult(String.format(MESSAGE_SUCCESS, String.join(", ", moduleCodeList)), archivePath,
                isImportingAllModules, isOverwritingExistingModule, moduleCodeSet);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof ImportCommand)) {
            return false;
        }

        ImportCommand otherCommand = (ImportCommand) other;

        return fileName.equals(otherCommand.fileName)
                && moduleCodeSet.equals(otherCommand.moduleCodeSet)
                && (isOverwritingExistingModule == otherCommand.isOverwritingExistingModule)
                && (isImportingAllModules == otherCommand.isImportingAllModules);
    }
}

