package itmo.p3108.util;

import itmo.p3108.UDPReceiver;
import itmo.p3108.UDPSender;
import itmo.p3108.command.type.Command;

import java.util.Optional;

public class Executor {
    private Executor() {
    }

    public static void executeCommand(UDPSender udpSender, UDPReceiver receiver) {

        Optional<byte[]> serializedObject = receiver.receive();
        serializedObject.ifPresentOrElse(x -> {
            Optional<?> command = DeserializeObject.deserializeObject(x);
            command.ifPresentOrElse(co -> {
                if (co instanceof Command) {
                    String result = ((Command) co).execute();
                    udpSender.send(result, 8989);
                } else {
                    System.err.println("serializedObject isn't command");
                }
            }, () -> {
                System.err.println("command is null,Can't deserialize");
            });
        }, () -> {
            System.err.println("Didn't get  serializedObject");
        });
    }

}
