package itmo.p3108.chain;

import itmo.p3108.command.type.Command;
import itmo.p3108.exception.ValidationException;
import itmo.p3108.util.WrapperArgument;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class LastHandler implements Handler {
    @Override
    public Optional<?> processRequest(WrapperArgument wrapperArgument) {
        if (Command.controller.isEmpty()) {
            log.error("Collection is empty");
            throw new ValidationException("Collection is empty");
        }
        return Optional.of(wrapperArgument.getCommand());
    }
}
