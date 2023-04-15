package itmo.p3108.command;

import itmo.p3108.command.type.NoArgument;
import itmo.p3108.model.Person;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.util.stream.Collectors;

/**
 * Command Show,print  elements of collection
 * in order of addition if reorder wasn't invoked
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Show implements NoArgument {
    @Serial
    private static final long serialVersionUID = 547248021L;
    /**
     * @return show elements of collection
     * using to string method of elemenents
     */
    @Override
    public String execute() {

        return controller.getPersonList().stream()
                .map(Person::toString)
                .collect(Collectors.joining("\n"));
    }
    @Override
    public Class<?> getCommandClass() {
        return this.getClass();
    }
    @Override
    public String description() {
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    @Override
    public String name() {
        return "show";
    }
}
