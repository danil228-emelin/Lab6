package itmo.p3108.command.type;

import lombok.NonNull;

import java.util.Optional;

public interface OneArgument<T> extends Command {
    default String execute(Object argument) {
        return "Do nothing";
    }

    default T getParameter() {
        return null;
    }

    default Optional<Command> prepare(String argument) {
        return Optional.empty();
    }
 default void  setParameter(@NonNull T parameter){};

}
