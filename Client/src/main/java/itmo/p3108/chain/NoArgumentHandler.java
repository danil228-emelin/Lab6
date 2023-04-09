package itmo.p3108.chain;

import itmo.p3108.command.Exit;
import itmo.p3108.command.type.Command;
import itmo.p3108.command.type.NoArgumentCommand;
import itmo.p3108.exception.CommandException;
import itmo.p3108.util.WrapperArgument;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class NoArgumentHandler implements Handler {
    private static final Handler handler = new FilterStartWithNameHandler();

    @Override
    public Optional<?> processRequest(WrapperArgument wrapperArgument) {
        Command command = wrapperArgument.getCommand();
        String[] commandLine = wrapperArgument.getArgument();
        if (command instanceof NoArgumentCommand) {
            if (commandLine.length > 1) {
                log.error("Error during execution command " + command.name() + " doesn't have arguments");
                throw new CommandException("Error during execution command " + command.name() + " doesn't have arguments");
            }
            if (command instanceof Exit) {
                (command).execute();
            }
            return Optional.of(command);


        } else if (commandLine.length > 2 || commandLine.length == 1) {
            log.error("Error during execution command " + command.name() + " has one argument ");
            throw new CommandException("Error during execution command " + command.name() + " has one argument ");
        }
        return handler.processRequest(wrapperArgument);
    }
}