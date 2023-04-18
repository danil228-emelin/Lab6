package commands;

import itmo.p3108.command.RemoveById;
import itmo.p3108.model.Person;
import itmo.p3108.util.CollectionController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class RemoveByIdTest {
    RemoveById removeById;
    CollectionController controller;

    @BeforeEach
    public void init() {
        removeById = new RemoveById();
        controller = CollectionController.getInstance();
    }
    @AfterEach
    public void destruct(){
        controller.getPersonList().clear();
    }
    @Test
//    @Disabled
    public void check_size_after_addIfMax() {

        Person testPerson = Person.builder().personId(1L).build();
        controller.getPersonList().add(testPerson);
        removeById.execute(1L);
        Assertions
                .assertThat(controller
                        .getPersonList()
                        .size())
                .as("RemoveById  doesn't remove element from collection")
                .isEqualTo(0);
    }
}
