package itmo.p3108.command;

import itmo.p3108.command.type.Command;
import itmo.p3108.command.type.OneArgument;
import itmo.p3108.exception.FileException;
import itmo.p3108.exception.ValidationException;
import itmo.p3108.util.FileWorker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.Serial;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ExecuteScript implements OneArgument<String> {
    @Serial
    private static final long serialVersionUID = 549988001L;
    private static final String ERROR_PERMISSION = "ExecuteScript error during execute script:file  doesn't exist or unreadable";
    private static int executingFails = 0;
    private final Set<Path> EXECUTED_FAILS = new HashSet<>();

    @Override
    public String name() {
        return "execute_script";
    }

    @Override
    public Optional<Command> prepare(@NonNull String argument) {
        Path test;
        try {
            test = Path.of(argument);
        } catch (InvalidPathException exception) {
            log.error(exception.toString());
            throw new FileException("Error during executing script:wrong file name");
        }
        if (!Files.exists(test) || !Files.isReadable(test)) {
            throw new FileException(ERROR_PERMISSION);
        }
        try {
            String[] commands = FileWorker.read(argument).split("\n");
            final int MAXIMUM_COMMANDS_IN_FILE = 15;
            if (commands.length > MAXIMUM_COMMANDS_IN_FILE) {
                log.error(String.format("Error during executing script:%s has disallowed amount of commands ", argument));
                throw new ValidationException(String.format("Error during executing script:%s has disallowed amount of commands ", argument));
            }
            final int MAXIMUM_FILES = 49;
            if (EXECUTED_FAILS.size() > MAXIMUM_FILES) {
                log.error(String.format("Error during executing script:%s processed maximum filed already ", argument));
                throw new ValidationException(String.format("Error during executing script:%s processed maximum filed already ", argument));
            }
            if (EXECUTED_FAILS.contains(test)) {
                log.error("Recursion is forbidden");
                throw new ValidationException(String.format("Error during executing script:Recursion is forbidden,file already executed %s", argument));
            }
            executingFails++;
            EXECUTED_FAILS.add(test);
            AnalyzeExecuteScript.analyze(commands);

        } catch (IOException exception) {
            log.error(exception.toString());
            System.err.println("Error during executing script:File is wrong");
        }
        executingFails--;
        if (executingFails == 0) {
            EXECUTED_FAILS.clear();
        }
        return Optional.empty();
    }
}

