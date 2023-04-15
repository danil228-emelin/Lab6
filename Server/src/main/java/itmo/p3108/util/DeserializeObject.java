package itmo.p3108.util;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Optional;

@Slf4j
public class DeserializeObject {
    private DeserializeObject() {
    }

    public static Optional<?> deserializeObject(byte[] serializedObject) {
        try {
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(serializedObject));
            Object object = in.readObject();
            in.close();
            log.info("message deserialized");
            return Optional.of(object);
        } catch (IOException | ClassNotFoundException exception) {
            log.error(exception.getMessage());
            return Optional.empty();
        }
    }
}
