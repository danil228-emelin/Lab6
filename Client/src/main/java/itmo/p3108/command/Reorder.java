package itmo.p3108.command;

import itmo.p3108.command.type.NoArgument;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;

/**
 * Command reorder,reorder collection in reverse order
 * provided with default comparator,compare by id
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Reorder implements NoArgument {
    @Serial
    private static final long serialVersionUID = 547248001L;



    @Override
    public String name() {
        return "reorder";
    }
}
