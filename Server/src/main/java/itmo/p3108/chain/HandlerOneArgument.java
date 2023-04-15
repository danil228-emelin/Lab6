package itmo.p3108.chain;

import itmo.p3108.command.FlyWeightCommandFactory;
import itmo.p3108.command.type.Command;
import itmo.p3108.command.type.OneArgument;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class HandlerOneArgument implements Handler {
    private static final Handler HANDLER = new HandlerNoArgument();

    @Override
    public String processRequest(Command command) {
        if (command instanceof OneArgument clientCommand) {
            Optional<Command> OptionalServerCommand = FlyWeightCommandFactory.getInstance().getCommand(command.name());
            if (OptionalServerCommand.isPresent()) {
                OneArgument serverCommand = (OneArgument) OptionalServerCommand.get();
                log.info(String.format("Try to execute %s", command.name()));
                return serverCommand.execute(clientCommand.getParameter());
            } else {
                log.error(String.format("can't find %s", command.name()));
                return String.format("can't find %s", command.name());
            }
        }
        return HANDLER.processRequest(command);
    }
}
