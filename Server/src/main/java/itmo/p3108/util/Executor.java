package itmo.p3108.util;

import itmo.p3108.UDPReceiver;
import itmo.p3108.UDPSender;

import java.util.Optional;

public class Executor {
    private Executor() {
    }

    public static void executeCommand(UDPSender udpSender, UDPReceiver receiver) {

        Optional<byte[]> serializedObject = receiver.receive();
        serializedObject.ifPresentOrElse(x -> {
            Optional<?> command = DeserializeObject.deserializeObject(x);
            command.ifPresentOrElse(co -> {
                if (co instanceof MessageServer messageServer) {
                    String result = messageServer.getCommand().execute();
                    udpSender.send(result, messageServer.getPort());
                } else {
                    System.err.println("serializedObject isn't messageServer");
                }
            }, () -> {
                System.err.println("message is null,Can't deserialize");
            });
        }, () -> {
            System.err.println("Didn't get  message");
        });
    }

}
