package itmo.p3108.chain;

import itmo.p3108.command.FlyWeightCommandFactory;
import itmo.p3108.command.type.Command;
import itmo.p3108.command.type.OneArgument;

import java.util.Optional;

public class HandlerOneArgument implements Handler {
    private static final Handler HANDLER = new HandlerNoArgument();

    @Override
    public String processRequest(Command command) {
        if (command instanceof OneArgument clientCommand) {
            Optional<Command> OptionalServerCommand = FlyWeightCommandFactory.getInstance().getCommand(command.name());
            if (OptionalServerCommand.isPresent()) {
                OneArgument serverCommand = (OneArgument) OptionalServerCommand.get();
                return serverCommand.execute(clientCommand.getParameter());
            } else return String.format("can't find %s", command.name());

        }
        return HANDLER.processRequest(command);
    }
}
