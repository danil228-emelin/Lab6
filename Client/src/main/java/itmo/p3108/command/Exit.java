package itmo.p3108.command;

import itmo.p3108.command.type.Command;
import itmo.p3108.command.type.NoArgument;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * Command exit,exit without saving collection
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Exit implements NoArgument {
    public Optional<Command> execute() {
        log.warn(" command didn't save collection before exit");
        System.exit(0);
        return Optional.of(this);
    }

    @Override
    public String name() {
        return "exit";
    }
}
