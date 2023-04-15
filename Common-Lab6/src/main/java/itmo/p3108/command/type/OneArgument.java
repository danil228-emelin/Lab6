package itmo.p3108.command.type;

import java.util.Optional;

public interface OneArgument extends Command {
    default String execute(Object argument) {
        return "Do nothing";
    }

    default Object getParameter() {
        return null;
    }

    default Optional<Command> prepare(String argument) {
        return Optional.empty();
    }


}
