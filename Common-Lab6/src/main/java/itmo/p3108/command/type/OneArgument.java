package itmo.p3108.command.type;

import lombok.NonNull;

import java.util.Optional;

public interface OneArgument<T> extends Command {
    String execute(T argument);

    T getParameter();

    void setParameter(@NonNull T parameter);

    Optional<Command> prepare(String argument);
}
