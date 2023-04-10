package itmo.p3108.command.type;

/**
 * common interface for all commands,
 * if command implement only this interface,it is implied that it has  one argument
 */
public interface OneArgument extends Command {
    void execute(String argument);
}
