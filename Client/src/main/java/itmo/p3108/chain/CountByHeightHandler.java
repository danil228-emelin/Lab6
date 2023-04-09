package itmo.p3108.chain;

import itmo.p3108.command.CountByHeight;
import itmo.p3108.command.type.Command;
import itmo.p3108.util.WrapperArgument;

import java.util.Optional;

public class CountByHeightHandler implements Handler {
private static final Handler handler =new UpdateHandler();
    @Override
    public Optional<?> processRequest(WrapperArgument wrapperArgument) {
        Command command = wrapperArgument.getCommand();
        String[] commandLine = wrapperArgument.getArgument();
        if (command instanceof CountByHeight) {
            double l = Double.parseDouble(commandLine[1]);
            ((CountByHeight) command).setHeight(l);
            return Optional.of(command);
        }
    return handler.processRequest(wrapperArgument);
    }
}
