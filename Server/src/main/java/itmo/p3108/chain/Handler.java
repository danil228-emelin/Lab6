package itmo.p3108.chain;

import itmo.p3108.command.type.Command;

public interface Handler {
String processRequest(Command command);
}
