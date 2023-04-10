package itmo.p3108.command;

import itmo.p3108.command.type.Command;
import itmo.p3108.command.type.NoArgument;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;

/**
 * Command Info, put out major information of collection
 * Size,Collection Type,Initialization Date
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Info implements NoArgument {
    @Serial
    private static final long serialVersionUID = 589988003L;
    @Override

    /**
     * put out major information of collection
     */
    public String execute() {
        return controller.info();
    }

    @Override
    public String description() {
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }


    @Override
    public String name() {
        return "info";
    }
}
