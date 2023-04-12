package itmo.p3108.util;

import itmo.p3108.command.type.Command;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

@Slf4j
public class SerializeObject {
    private static final Queue<byte[]> MESSAGE = new LinkedList<>();

    private SerializeObject() throws IOException {
    }

    public static <T extends Command> Optional<byte[]> serialize(T command, int port) {
        try {
            MessageServer messageServer = new MessageServer();
            messageServer.setCommand(command);
            messageServer.setPort(port);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(messageServer);
            objectOutputStream.flush();

            byte[] byteMessage = byteArrayOutputStream.toByteArray();
            if (byteArrayOutputStream.size() != 0) {
                MESSAGE.add(byteMessage);
            }
            return Optional.of(byteMessage);
        } catch (IOException exception) {
            log.error(exception.getMessage());
            return Optional.empty();
        }
    }

    public static int size() {
        return MESSAGE.size();
    }



    public static void remove() {
        MESSAGE.remove();
    }

    public static byte[] peek() {
        return MESSAGE.peek();
    }
}
