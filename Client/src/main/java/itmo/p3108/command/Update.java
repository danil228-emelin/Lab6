package itmo.p3108.command;

import itmo.p3108.command.type.OneArgument;
import itmo.p3108.exception.ValidationException;
import itmo.p3108.model.Person;
import itmo.p3108.model.PersonReadingBuilder;
import itmo.p3108.util.CheckData;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
    public String name() {
        return "update";
    }

    @Override
    public void execute(@NonNull String argument) {
        boolean validation = new CheckData().checkPersonId(argument);
        if (!validation) {
            throw new ValidationException("argument isn't a positive number");
        }
        Long id = Long.valueOf(argument);
        person = CreatePerson.createPerson();
        person.setPersonId(id);
        PersonReadingBuilder.setId(PersonReadingBuilder.getId() - 1);
    }
}
