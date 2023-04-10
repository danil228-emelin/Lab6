package itmo.p3108.command;

import itmo.p3108.command.type.OneArgument;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;

/**
 * Command FilterStartsWithName, print all elements,which name start with given argument.
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class FilterStartsWithName implements OneArgument {

    @Serial
    private static final long serialVersionUID = 589988002L;
    private String substring;

    @Override
    public String name() {
        return "filter_starts_with_name";
    }

    @Override
    public void execute(@NonNull String argument) {
        substring = argument;
    }


}
