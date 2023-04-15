package itmo.p3108.command;

import itmo.p3108.command.type.OneArgument;
import itmo.p3108.exception.ValidationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import itmo.p3108.model.Person;
import java.io.Serial;
import java.util.stream.Collectors;

/**
 * Command FilterStartsWithName, print all elements,which name start with given argument.
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class FilterStartsWithName implements  OneArgument {

    @Serial
    private static final long serialVersionUID = 589988002L;
    private String substring;

    /**
     * @return the result of command
     */


    @Override
    public String description() {
        return "filter_start_with_name name:выводит элементы чье имя начинается с name";
    }

    @Override
    public String name() {
        return "filter_starts_with_name";
    }
    @Override
    public Class<?> getCommandClass() {
        return this.getClass();
    }
    /**
     * set the argument
     */

    @Override
    public String execute(Object argument) {
        if (argument instanceof String s) {
            log.info(String.format("%s executed successfully", this.name()));
            return
                    controller
                            .getPersonList()
                            .stream()
                            .filter(x -> x.getPersonName().startsWith(s))
                            .parallel()
                            .map(Person::toString)
                            .collect(Collectors.joining("\n"));
        }
        log.info(String.format("%s Wrong argument", this.name()));

        throw new ValidationException("Wrong argument for FilterStartsWithName");
    }

    @Override
    public Object getParameter() {
        return substring;
    }
}
