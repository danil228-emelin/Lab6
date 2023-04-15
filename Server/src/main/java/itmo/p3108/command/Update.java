package itmo.p3108.command;

import itmo.p3108.command.type.OneArgument;
import itmo.p3108.exception.ValidationException;
import itmo.p3108.model.Person;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;

/**
 * Command update,update  exist element
 * has id of element  as parameter.
 * User has opportunity to stay previous state of attribute
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Update implements OneArgument {
    @Serial
    private static final long serialVersionUID = 547248024L;
    private Person person;

    @Override
    public Class<?> getCommandClass() {
        return this.getClass();
    }

    @Override
    public String description() {
        return "update id:обновить элемент с заданным id";
    }

    @Override
    public String name() {
        return "update";
    }

    @Override
    public String execute(Object argument) {
        if (argument instanceof Person person1) {
            boolean updated = controller.updatePerson(person1);
            if (!updated) {
                throw new ValidationException(String.format("Person with %d doesn't exist", person1.getPersonId()));
            }
            return String.format("Person with %d updated", person1.getPersonId());

        }
        throw new ValidationException("argument for Update must be type Person");

    }

    @Override
    public Object getParameter() {
        return person;
    }
}
