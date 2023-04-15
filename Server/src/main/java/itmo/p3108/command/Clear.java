package itmo.p3108.command;

import itmo.p3108.command.type.NoArgument;
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
    private final static String SUCCESS = "Command Clear deleted elements ";

    /**
     * Command clear,clear collection  after execution size=0
     */
    @Override

    public String execute() {
        controller.getPersonList().clear();
        return SUCCESS;
    }
    @Override
    public Class<?> getCommandClass() {
        return this.getClass();
    }
    @Override
    public String description() {
        return "clear : очистить коллекцию";
    }

    @Override
    public String name() {
        return "clear";
    }
}
