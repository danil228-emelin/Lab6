package itmo.p3108.command.type;

import itmo.p3108.util.CollectionController;

import java.io.Serializable;

/**
 * common interface for all commands,
 * if command implement only this interface,it is implied that it has  one argument
 */
public interface Command extends Serializable {
    CollectionController controller = CollectionController.getInstance();

    String description();

    String name();
}
