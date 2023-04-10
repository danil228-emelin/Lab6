package itmo.p3108.command;

import itmo.p3108.command.type.NoArgument;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;

/**
 * Command Help,put out information about commands
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Help implements NoArgument {
    @Serial
    private static final long serialVersionUID = 547988001L;
    @Override
    public String name() {
        return "help";
    }
}
