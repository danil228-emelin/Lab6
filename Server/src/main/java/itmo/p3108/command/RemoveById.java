package itmo.p3108.command;

import itmo.p3108.command.type.Command;
import itmo.p3108.command.type.OneArgument;
import itmo.p3108.exception.ValidationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;

/**
 * Command RemoveByID,remove element with certain id,
 * has int number as parameter
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class RemoveById implements  OneArgument {
    @Serial
    private static final long serialVersionUID = 547968001L;
    private Long id;

    @Override
    public String description() {
        return "remove_by_id id:удалить из коллекции элемент с заданным id";
    }

    @Override
    public String name() {
        return "remove_by_id";
    }

    @Override
    public Class<?> getCommandClass() {
        return this.getClass();
    }
    @Override
    public String execute(Object argument) {
        if (argument instanceof Long id) {
            if (id <= 0) {
                log.error(" RemoveById error id<=0");
                throw new ValidationException("RemoveById error id<=0");
            }

            if (!controller.isPersonExist(id)) {

                return "RemoveById error:person with such id doesn't exit";
            }
            controller.getPersonList().removeIf(x -> x.getPersonId().equals(id));
            return "element with  id " + id + " was deleted ";

        }
        throw new ValidationException("Wrong argument for RemoveById");
    }

    @Override
    public Object getParameter() {
        return id;
    }
}
