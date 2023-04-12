package itmo.p3108.command;

import itmo.p3108.command.type.NoArgument;
import itmo.p3108.model.PersonReadingBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;

/**
 * Command Clear,clear collection
 * don't save elements before cleaning
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Clear implements NoArgument {
    @Serial
    private static final long serialVersionUID = 569988001L;
    @Override
    public String name() {
        return "clear";
    }

    @Override
    public void execute() {
        PersonReadingBuilder.setId(1L);
    }
}
