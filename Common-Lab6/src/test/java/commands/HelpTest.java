package commands;

import itmo.p3108.command.FlyWeightCommandFactory;
import itmo.p3108.command.Help;
import itmo.p3108.util.CollectionController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HelpTest {
    Help help;
    CollectionController controller;

    @BeforeEach
    public void init() {
        help = new Help();
        controller = CollectionController.getInstance();
    }
    @AfterEach
    public void destruct(){
        controller.getPersonList().clear();
    }
    @Test
    public void check_help() {
        Assertions
                .assertThat(help.execute()
                        .split("\n").length)
                .as("Help doesn't put out all descriptions")
                .isEqualTo(FlyWeightCommandFactory.getInstance().getValues().size());

    }
}
