package itmo.p3108.command;

import itmo.p3108.command.type.NoArgument;
import itmo.p3108.model.Person;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.util.Comparator;

/**
 * Command reorder,reorder collection in reverse order
 * provided with default comparator,compare by id
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Reorder implements NoArgument {
    @Serial
    private static final long serialVersionUID = 547248001L;
    private final static String SUCCESS = "Command reorder:collection reordered ";
    @Setter
    @NonNull
    private Comparator<Person> naturalComparatorOrder = Comparator.comparing(Person::getPersonId);
    @Override
    public Class<?> getCommandClass() {
        return this.getClass();
    }
    /**
     * if collection has been already reversed,
     * using natural order to return to initial order
     */

    @Override
    public String execute() {
        naturalComparatorOrder = naturalComparatorOrder.reversed();
        controller.getPersonList().sort(naturalComparatorOrder);

        return SUCCESS;
    }

    @Override
    public String description() {
        return "reorder:сортировать коллекцию в обратном порядке";
    }

    @Override
    public String name() {
        return "reorder";
    }
}
