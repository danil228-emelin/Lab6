package itmo.p3108.command;

import itmo.p3108.command.type.Command;
import itmo.p3108.command.type.OneArgument;
import itmo.p3108.exception.ValidationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;

/**
 * Command CountByHeight,count elements with certain height,
 * don't work if collection is empty.
 * Has one parameter height
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CountByHeight implements  OneArgument {
    @Serial
    private static final long serialVersionUID = 559988001L;
    private double height;

    @Override
    public String description() {
        return
                "count_by_height height:посчитать количество элементов с заданным возростом";
    }

    @Override
    public String name() {
        return "count_by_height";
    }


    @Override
    public String execute(Object argument) {
        if (argument instanceof Double height) {
            return Long.toString(controller.getPersonList().stream().parallel().filter(x -> x.getPersonHeight().compareTo(height) == 0).count());
        }
        throw new ValidationException("Wrong argument for CountByHeight");
    }
    @Override
    public Class<?> getCommandClass() {
        return this.getClass();
    }
    @Override
    public Object getParameter() {
        return height;
    }
}
