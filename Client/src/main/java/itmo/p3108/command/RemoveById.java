package itmo.p3108.command;

import itmo.p3108.command.type.OneArgument;
import itmo.p3108.exception.ValidationException;
import itmo.p3108.util.CheckData;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.Serial;


@Slf4j
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class RemoveById implements OneArgument {
    @Serial
    private static final long serialVersionUID = 547968001L;
    private Long id;

    @Override
    public String name() {
        return "remove_by_id";
    }


    @Override
    public void execute(@NonNull String id) {
        boolean validation = new CheckData().checkPersonId(id);
        if (!validation) {
            throw new ValidationException("id isn't positive number");
        }
        this.id = Long.valueOf(id);
    }
}
