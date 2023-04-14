package itmo.p3108.command.type;

import java.util.Optional;

/**
 * common interface for all commands,
 * if command implement only this interface,it is implied that it has  one argument
 */
public interface OneArgument extends Command {
    default Optional<Command> execute(String argument) {
        return Optional.empty();
    }
}
