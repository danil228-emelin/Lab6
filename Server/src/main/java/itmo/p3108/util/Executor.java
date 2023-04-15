package itmo.p3108.util;

import itmo.p3108.UDPReceiver;
import itmo.p3108.UDPSender;
import itmo.p3108.chain.Handler;
import itmo.p3108.chain.HandlerOneArgument;
import itmo.p3108.exception.ValidationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Executor {
    private static final Handler HANDLER = new HandlerOneArgument();



    public static void executeCommand(UDPSender udpSender, UDPReceiver receiver) {

        Optional<byte[]> serializedObject = receiver.receive();
        serializedObject.ifPresentOrElse(x -> {
            Optional<?> command = DeserializeObject.deserializeObject(x);
            command.ifPresentOrElse(co -> {
                if (co instanceof MessageServer messageServer) {
                    String result = null;
                    try {
                        result = HANDLER.processRequest(messageServer.getCommand());

                    } catch (ValidationException validationException) {
                        log.error(validationException.getMessage());
                        result = validationException.getMessage();
                    }
                    udpSender.send(result, messageServer.getPort());
                } else {


                    System.err.println("serializedObject isn't messageServer");
                }
            }, () -> {
                System.err.println("message is incorrect,Can't deserialize");
            });
        }, () -> {
            System.err.println("message is null");
        });
    }

}
