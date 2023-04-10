package itmo.p3108.command;

import itmo.p3108.command.type.NoArgument;
import itmo.p3108.command.type.OneArgument;
import itmo.p3108.exception.ValidationException;
import itmo.p3108.model.Person;
import itmo.p3108.model.PersonReadingBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.io.Serializable;

/**
 * Command Add,add element in collection
 * <p>
 * User enters data,but  while script executing Add take arguments from script file
 * Next line is treated as arguments
 *
 *
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Add implements OneArgument {
    private static final PersonReadingBuilder personReadingBuilder = PersonReadingBuilder.getInstance();
    @Serial
    private static final long serialVersionUID = 589988001L;
    private Person person;

    public void execute(String argument) {

        if (argument != null) {
            throw new ValidationException("Add doesn't have argument");
        }
        person = CreatePerson.createPerson();
    }



    @Override
    public String name() {
        return "add";
    }
}
