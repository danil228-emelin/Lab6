package itmo.p3108.util;

import itmo.p3108.command.type.Command;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Optional;

@Slf4j
public class SerializeObject {
    private SerializeObject() {
    }


    public static <T extends Command> Optional<byte[]> serialize(T command,int port) {
        try {
            MessageServer messageServer = new MessageServer();
            messageServer.setCommand(command);
            messageServer.setPort(port);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(messageServer);
            objectOutputStream.flush();
            return Optional.of(byteArrayOutputStream.toByteArray());
        } catch (IOException exception) {
            log.error(exception.getMessage());
            return Optional.empty();
        }
    }
}
