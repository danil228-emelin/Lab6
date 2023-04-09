package itmo.p3108.chain;

import itmo.p3108.command.FilterStartsWithName;
import itmo.p3108.command.type.Command;
import itmo.p3108.util.WrapperArgument;

import java.util.Optional;

public class FilterStartWithNameHandler implements Handler {
    private static final Handler handler = new RemoveByIdHandler();

    @Override
    public Optional<?> processRequest(WrapperArgument wrapperArgument) {
        Command command = wrapperArgument.getCommand();
        String[] commandLine = wrapperArgument.getArgument();
        if (command instanceof FilterStartsWithName) {
            ((FilterStartsWithName) command).setSubstring(commandLine[1]);
            return Optional.of(command);
        }
        return handler.processRequest(wrapperArgument);
    }


}
