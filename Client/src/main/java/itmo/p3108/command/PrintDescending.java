package itmo.p3108.command;

import itmo.p3108.command.type.NoArgument;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;

/**
 * Command Print Descending, print in descending order
 * provided with default comparator,compare by id
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class PrintDescending implements NoArgument {
    @Serial
    private static final long serialVersionUID = 547998001L;
    @Override
    public String name() {
        return "print_descending";
    }
}
