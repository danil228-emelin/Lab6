package itmo.p3108.util;

import itmo.p3108.command.type.Command;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

@Slf4j
public class SerializeObject {
    private static final Queue<byte[]> MESSAGE = new LinkedList<>();

    private SerializeObject() {
    }

    private static boolean createMessage(MessageServer messageServer, ByteArrayOutputStream byteArrayOutputStream) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(messageServer);
            objectOutputStream.flush();
            byte[] byteMessage = byteArrayOutputStream.toByteArray();
            if (byteMessage.length != 0) {
                log.info(String.format("Add Message with %s", messageServer.getCommand().name()));
                MESSAGE.add(byteMessage);
            }
            return true;
        } catch (IOException exception) {
            log.error(exception.toString());
            return false;
        }
    }


    public static <T extends Command> Optional<byte[]> serialize(T command) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

            MessageServer messageServer = new MessageServer();
            messageServer.setCommand(command);
            messageServer.setPort(ServerChanel.getAddress());
            boolean result = createMessage(messageServer, byteArrayOutputStream);
            if (result) {
                log.info(String.format("serialize command %s", messageServer.getCommand().name()));
                return Optional.of(byteArrayOutputStream.toByteArray());
            }
            return Optional.empty();

        } catch (IOException e) {
            log.error(e.toString());
            return Optional.empty();
        }
    }


    public static void remove() {
        log.info(String.format("Delete message %s", Arrays.toString(MESSAGE.poll())));
    }

    public static byte[] peek() {
        return MESSAGE.peek();
    }


}
