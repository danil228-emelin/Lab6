package itmo.p3108.command.type;

import java.util.Optional;

/**
 * interface-marker,implements by no argument command
 */
public interface NoArgument extends Command {
    default String execute() {
        return "no execution";
    }
    default Optional<Command> prepare() {
        return Optional.empty();
    }


}
