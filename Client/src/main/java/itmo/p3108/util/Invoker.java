package itmo.p3108.util;

import itmo.p3108.chain.Handler;
import itmo.p3108.chain.NoArgumentHandler;
import itmo.p3108.command.FlyWeightCommandFactory;
import itmo.p3108.command.type.Command;
import itmo.p3108.exception.CommandException;
import itmo.p3108.exception.FileException;
import itmo.p3108.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Optional;

/**
 * Class invoker,invoke and analyze commands
 */
@Slf4j
public class Invoker {
    private static final Handler handler = new NoArgumentHandler();
    private static final Invoker invoker = new Invoker();
    private static final FlyWeightCommandFactory flyWeightCommandFactory = FlyWeightCommandFactory.getInstance();

    private Invoker() {
    }

    public static Invoker getInstance() {
        return invoker;
    }

    public Collection<Command> commands() {
        return flyWeightCommandFactory.getValues();
    }


    /**
     * analyzing for different conditions  and then try to invoke command
     */
    public Optional<Command> invoke(String commandStr) {
        try {
            if (commandStr.equals("")) {
                return Optional.empty();
            }
            String[] strings;
            if (commandStr.contains("\"")) {
                strings = commandStr.split("\"");
                String s = strings[0];
                strings[0] = s.trim().toLowerCase();
            } else {
                strings = commandStr.trim().split("\\s+");
            }
            if (!flyWeightCommandFactory.contains(strings[0])) {

                throw new CommandException("Error during execution command doesn't exist,use help command");
            }
            Command command = flyWeightCommandFactory.getCommand(strings[0]).get();
            WrapperArgument wrapperArgument = new WrapperArgument();
            wrapperArgument.setArgument(strings);
            wrapperArgument.setCommand(command);


            return (Optional<Command>) handler.processRequest(wrapperArgument);
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

