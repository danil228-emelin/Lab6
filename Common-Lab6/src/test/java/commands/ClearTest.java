package commands;

import itmo.p3108.command.Clear;
import itmo.p3108.util.CollectionController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClearTest {

    Clear clear;
    CollectionController controller;

    @BeforeEach
    public void init() {
        clear = new Clear();
        controller = CollectionController.getInstance();
    }
    @AfterEach
    public void destruct(){
        controller.getPersonList().clear();
    }
    @Test
    public void check_size_after_clear_collection() {
        clear.execute();
        Assertions
                .assertThat(controller.getPersonList().size())
                .describedAs("Clear command doesnt' clear collection")
                .isEqualTo(0);
    }
}
