package itmo.p3108.command;

import itmo.p3108.command.type.Command;
import itmo.p3108.command.type.OneArgument;
import itmo.p3108.exception.ValidationException;
import itmo.p3108.util.CheckData;
import itmo.p3108.util.CollectionController;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.util.Optional;

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
    public String execute(Object argument) {
        if (argument instanceof Long id) {
            if (CollectionController.getInstance().isEmpty()) {
                throw new ValidationException("Collection is empty");
            }
            if (id <= 0) {
                log.error(" RemoveById error id<=0");
                throw new ValidationException("RemoveById error id<=0");
            }

            if (!CollectionController.getInstance().isPersonExist(id)) {
                log.info(String.format("%s person with  id %d doesn't exit", this.name(),id));

                return "RemoveById error:person with such id doesn't exit";
            }
            CollectionController.getInstance().getPersonList().removeIf(x -> x.getPersonId().equals(id));
            log.info(String.format("%s person with  id %d deleted", this.name(),id));

            return "element with  id " + id + " was deleted ";

        }
        log.error(String.format("%s Wrong argument", this.name()));

        throw new ValidationException("Wrong argument for RemoveById");
    }
    @Override
    public Optional<Command> prepare(@NonNull String id) {
        boolean validation = new CheckData().checkPersonId(id);
        if (!validation) {
            throw new ValidationException("id isn't positive number");
        }
        this.id = Long.valueOf(id);
        return Optional.of(this);
    }
    @Override
    public Object getParameter() {
        return id;
    }
}
