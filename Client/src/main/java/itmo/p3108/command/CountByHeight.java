package itmo.p3108.command;

import itmo.p3108.command.type.Command;
import itmo.p3108.command.type.OneArgument;
import itmo.p3108.exception.ValidationException;
import itmo.p3108.util.CheckData;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.util.Optional;

/**
 * Command CountByHeight,count elements with certain height,
 * don't work if collection is empty.
 * Has one parameter height
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class CountByHeight implements OneArgument {
    @Serial
    private static final long serialVersionUID = 559988001L;
    private static final String VALIDATION_ERROR = "CountBtHeight error during setting height:height must be more than 0";
    private double height;


    @Override
    public String name() {
        return "count_by_height";
    }

    /**
     * set height,call before execute method
     */
    public Optional<Command> execute(@NonNull String height) {
        boolean validation = new CheckData().checkPersonHeight(height);
        if (!validation) {
            throw new ValidationException("height isn't positive number");
        }
        this.height = Double.parseDouble(height);
    return Optional.of(this);
    }
}
