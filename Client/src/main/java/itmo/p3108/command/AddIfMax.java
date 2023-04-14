package itmo.p3108.command;

import itmo.p3108.command.type.Command;
import itmo.p3108.command.type.OneArgument;
import itmo.p3108.exception.ValidationException;
import itmo.p3108.model.Person;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.util.Optional;

/**
 * AddIfMax,add element in collection if it is bigger than the max element in collection
 * If collection is empty add element
 * default comparator compared by name and them by id
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class AddIfMax implements OneArgument {
    @Serial
    private static final long serialVersionUID = 579988001L;
    private Person person;

    @Override
    public Optional<Command> execute(String object) {

        if (object != null) {
            throw new ValidationException("AddIfMax doesn't have argument");
        }
        this.person = CreatePerson.createPerson();
   return Optional.of(this);
    }

    @Override
    public String name() {


        return "add_if_max";
    }


}
