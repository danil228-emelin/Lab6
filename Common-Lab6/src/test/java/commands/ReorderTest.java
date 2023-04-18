package commands;

import itmo.p3108.command.Reorder;
import itmo.p3108.model.Person;
import itmo.p3108.util.CollectionController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReorderTest {
    Reorder reorder;
    CollectionController controller;

    @BeforeEach
    public void init() {
        reorder = new Reorder();
        controller = CollectionController.getInstance();
    }
    @AfterEach
    public void destruct(){
        controller.getPersonList().clear();
    }
    @Test
    public void check_test() {
        Person person1 = Person.builder().personId(1L).build();
        Person person2 = Person.builder().personId(2L).build();
        controller.getPersonList().add(person1);
        controller.getPersonList().add(person2);
        reorder.execute();
        Assertions
                .assertThat(controller.getPersonList().get(0).getPersonId())
                .as("reorder doesn't reorder collection")
                .isEqualTo(2);
    }
}
