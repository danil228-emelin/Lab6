package itmo.p3108.chain;

import itmo.p3108.command.FlyWeightCommandFactory;
import itmo.p3108.command.type.Command;
import itmo.p3108.command.type.NoArgument;

import java.util.Optional;

public class HandlerNoArgument implements Handler {

    @Override
    public String processRequest(Command command) {
        if (command instanceof NoArgument) {
            Optional<Command> OptionalServerCommand = FlyWeightCommandFactory.getInstance().getCommand(command.name());
            if (OptionalServerCommand.isPresent()) {
                NoArgument serverCommand = (NoArgument) OptionalServerCommand.get();
                return serverCommand.execute();
            } else return String.format("can't find %s", command.name());

        }

        return String.format("can't find %s", command.name());
    }
}
