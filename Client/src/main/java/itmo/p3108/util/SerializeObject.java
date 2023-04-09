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


    public static <T extends Command> Optional<byte[]> serialize(T command) {
        try {


            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(command);
            objectOutputStream.flush();
            return Optional.of(byteArrayOutputStream.toByteArray());
        } catch (IOException exception) {
            log.error(exception.getMessage());
            return Optional.empty();
        }
    }
}
