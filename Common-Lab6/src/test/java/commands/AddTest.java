package commands;

import itmo.p3108.command.Add;
import itmo.p3108.model.Person;
import itmo.p3108.util.CollectionController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddTest {
    Add add;
    CollectionController controller;

    @BeforeEach
    public void init() {
        add = new Add();
        controller = CollectionController.getInstance();
    }
    @AfterEach
    public void destruct(){
        controller.getPersonList().clear();
    }
    @Test
    public void check_size_after_add() {
        Person person = new Person();
        add.setPerson(person);
        add.execute();
        Assertions
                .assertThat(controller.getPersonList().size())
                .describedAs("Add command doesnt' add element in collection")
                .isGreaterThan(0);
    }
}
