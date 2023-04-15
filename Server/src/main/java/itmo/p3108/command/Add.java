package itmo.p3108.command;

import itmo.p3108.command.type.OneArgument;
import itmo.p3108.exception.ValidationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import itmo.p3108.model.Person;

import java.io.Serial;

/**
 * Command Add,add element in collection
 * <p>
 * User enters data,but  while script executing Add take arguments from script file
 * Next line is treated as arguments
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Add implements OneArgument {
    @Serial
    private static final long serialVersionUID = 589988001L;
    private Person person;


    @Override
    public String description() {
        return "add {element} : добавить новый элемент в коллекцию";
    }


    @Override
    public String name() {
        return "add";
    }

    @Override
    public Class<?> getCommandClass() {
        return this.getClass();
    }

    @Override
    public String execute(Object argument) {
        if (argument instanceof Person person) {
            controller.getPersonList().add(person);
            log.info(String.format("%s executed successfully", this.name()));
            return "object added ";
        }
        log.error("Wrong argument for Add");
        throw new ValidationException("Wrong argument for Add");
    }

    @Override
    public Object getParameter() {
        return person;
    }
}
