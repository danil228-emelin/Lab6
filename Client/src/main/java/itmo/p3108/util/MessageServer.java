package itmo.p3108.util;

import itmo.p3108.command.type.Command;

import java.io.Serializable;

public class MessageServer implements Serializable {
    private Command command;
    private int port;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
