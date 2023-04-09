package itmo.p3108.chain;

import itmo.p3108.command.Update;
import itmo.p3108.command.type.Command;
import itmo.p3108.util.WrapperArgument;

import java.util.Optional;

public class UpdateHandler implements Handler {
    private static final Handler handler = new ExecuteScriptHandler();

    @Override
    public Optional<?> processRequest(WrapperArgument wrapperArgument) {
        Command command = wrapperArgument.getCommand();
        String[] commandLine = wrapperArgument.getArgument();
        if (command instanceof Update) {
            Long l = Long.parseLong(commandLine[1]);
            ((Update) command).findPerson(l);
            return Optional.of(command);


        }
        return handler.processRequest(wrapperArgument);
    }
}
