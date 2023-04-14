package itmo.p3108.command;

import itmo.p3108.command.type.Command;
import itmo.p3108.command.type.NoArgument;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.util.Optional;

/**
 * Command Show,print  elements of collection
 * in order of addition if reorder wasn't invoked
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Show implements NoArgument {
    @Serial
    private static final long serialVersionUID = 547248021L;

    @Override
    public Optional<Command> execute() {
        return Optional.of(this);
    }

    @Override
    public String name() {
        return "show";
    }
}
