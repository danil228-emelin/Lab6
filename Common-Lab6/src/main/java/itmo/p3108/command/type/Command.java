package itmo.p3108.command.type;

import java.io.Serializable;

/**
 * common interface for all commands,
 * if command implement only this interface,it is implied that it has  one argument
 */
public interface Command extends Serializable {

    default String description() {
        return "return nothing";
    }

    default String name() {
        return "no name";
    }
}
