import itmo.p3108.command.Show;
import itmo.p3108.command.type.Command;
import itmo.p3108.util.SerializeObject;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import java.util.Optional;

public class SerializeTest {
    @AfterEach
    void clean() {
        SerializeObject.clear();
    }

    @Test
    public void check_serialization() {
        Command command = new Show();
        Optional<byte[]> serialized = SerializeObject.serialize(command);
        Assertions
                .assertThat(serialized)
                .as("Serializer doesn't serialize command")
                .isPresent();

    }
}
