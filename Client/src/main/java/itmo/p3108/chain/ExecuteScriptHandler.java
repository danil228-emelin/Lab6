package itmo.p3108.chain;

import itmo.p3108.command.ExecuteScript;
import itmo.p3108.command.type.Command;
import itmo.p3108.exception.CommandException;
import itmo.p3108.exception.FileException;
import itmo.p3108.util.WrapperArgument;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Optional;

@Slf4j
public class ExecuteScriptHandler implements Handler {
    private final HashSet<String> executeScriptPaths = new HashSet<>();

    @Override
    public Optional<?> processRequest(WrapperArgument wrapperArgument) {
        Command command = wrapperArgument.getCommand();
        String[] commandLine = wrapperArgument.getArgument();
        if (command instanceof ExecuteScript) {
            if (executeScriptPaths.size() > 49) {
                throw new FileException("Too many files in executed_script");
            }
            String path = commandLine[1].toLowerCase();
            if (executeScriptPaths.contains(path)) {
                log.error(String.format("Error : execute_script can't be executed %s.Recursion is forbidden",
                        commandLine[1]));
                return Optional.of(command);


            }
            if (Files.exists(Path.of(path))) {
                executeScriptPaths.add(path);
                ((ExecuteScript) command).setPath(path);
                return Optional.of(command);


            } else {
                log.error("Error during execution command :file " + commandLine[1] + " doesn't exist");
                throw new CommandException("Error during execution command :file " + commandLine[1] + " doesn't exist");
            }
        }
        return Optional.empty();
    }
}
