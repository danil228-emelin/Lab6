package itmo.p3108.command.type;

import java.awt.*;
import java.io.Serializable;

/**
 * implements by command witch don't depend on the size of collection
 * it means it can work if collection is empty
 */
public interface IndependentCommand extends Serializable {
}
