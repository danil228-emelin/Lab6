package itmo.p3108.util;

import itmo.p3108.chain.Handler;
import itmo.p3108.chain.OneArgumentHandler;
import itmo.p3108.chain.WrapperArgument;
import itmo.p3108.command.FlyWeightCommandFactory;
import itmo.p3108.command.type.Command;
import itmo.p3108.exception.CommandException;
import itmo.p3108.exception.FileException;
import itmo.p3108.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * Class invoker,invoke and analyze commands
 */
@Slf4j
public class Invoker {
    private static final Handler<Command> HANDLER = new OneArgumentHandler();
    private static final Invoker INVOKER = new Invoker();
    private static final FlyWeightCommandFactory FLY_WEIGHT_COMMAND_FACTORY = FlyWeightCommandFactory.getInstance();

    private Invoker() {
    }

    public static Invoker getInstance() {
        return INVOKER;
    }


    /**
     * analyzing for different conditions  and then try to invoke command
     */
    public Optional<Command> invoke(String commandStr) {
        try {
            if (commandStr.trim().equals("")) {
                return Optional.empty();
            }
            String[] strings;

            strings = commandStr.trim().split("\\s+");
            String commandName = strings[0].toLowerCase().trim();
            if (!FLY_WEIGHT_COMMAND_FACTORY.contains(commandName)) {

                throw new CommandException("Error during execution command doesn't exist,use help command");
            }

            Command command = FLY_WEIGHT_COMMAND_FACTORY.getCommand(commandName).get();
            WrapperArgument wrapperArgument = new WrapperArgument();
            wrapperArgument.setArgument(strings);
            wrapperArgument.setCommand(command);
            log.info(String.format("try to execute %s", command.name()));
            return HANDLER.processRequest(wrapperArgument);
        } catch (NumberFormatException e) {
            log.error("Error during execution parameter must be a digit");
            System.err.println("Error during execution parameter must be a digit ");
        } catch (ValidationException | CommandException | FileException e) {
            log.error(e.getMessage());
            System.err.println(e.getMessage());
        }

        return Optional.empty();
    }
}

