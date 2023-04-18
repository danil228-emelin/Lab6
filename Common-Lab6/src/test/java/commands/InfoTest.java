package commands;

import itmo.p3108.command.Info;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InfoTest {
    Info info;

    @BeforeEach
    public void init() {
        info = new Info();
    }

    @Test
    public void check_test() {
        Assertions
                .assertThat(info.execute())
                .as("info consist wrong information")
                .startsWith("Тип:ArrayList");
    }
}
