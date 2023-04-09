package itmo.p3108.chain;

import itmo.p3108.command.RemoveById;
import itmo.p3108.command.type.Command;
import itmo.p3108.util.WrapperArgument;

import java.util.Optional;

public class RemoveByIdHandler implements Handler {
    private static final Handler handler = new CountByHeightHandler();

    @Override
    public Optional<?> processRequest(WrapperArgument wrapperArgument) {
        Command command = wrapperArgument.getCommand();
        String[] commandLine = wrapperArgument.getArgument();

        if (command instanceof RemoveById) {
            Long l = Long.parseLong(commandLine[1]);
            ((RemoveById) command).setId(l);
            return Optional.of(command);

        }
        return handler.processRequest(wrapperArgument);
    }
}
