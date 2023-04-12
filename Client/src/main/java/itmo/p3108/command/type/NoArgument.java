package itmo.p3108.command.type;

/**
 * interface-marker,implements by no argument command
 */
public interface NoArgument extends Command {

    default void execute() {
    }
}
