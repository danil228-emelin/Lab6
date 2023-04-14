package itmo.p3108.command;

import itmo.p3108.command.type.Command;
import itmo.p3108.command.type.NoArgument;
import itmo.p3108.command.type.OneArgument;
import itmo.p3108.model.Person;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.io.Serializable;
import java.util.Optional;

/**
 * Command Remove Greater,
 * remove elements witch greater than created element
 * after reading command,user creates new element.
 * if new element is greater than elements in collections will be deleted
 * provided with default comparator,compare by name and then birthday
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class RemoveGreater  implements OneArgument {
    @Serial
    private static final long serialVersionUID = 547268001L;
    private Person person;

    @Override
    public Optional<Command> execute(String object) {
        this.person = CreatePerson.createPerson();
        return Optional.of(this);
    }

    @Override
    public String name() {
        return "remove_greater";
    }

}
