package commands;

import itmo.p3108.command.Update;
import itmo.p3108.model.Person;
import itmo.p3108.util.CollectionController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class UpdateTest {
    Update update;
    CollectionController controller;

    @BeforeEach
    public void init() {
        update = new Update();
        controller = CollectionController.getInstance();
    }
    @AfterEach
    public void destruct(){
        controller.getPersonList().clear();
    }
    @Test
    //@Disabled
    public void check_test() {
        Person person1 = Person.builder().personName("B").personId(1L).build();
        Person updatedPerson = Person.builder().personId(1L).personName("A").build();
        controller.getPersonList().add(person1);
        update.execute(updatedPerson);
        Assertions
                .assertThat(controller.getPersonList().get(0).getPersonName())
                .as("Update doesn't update element")
                .isEqualTo("A");
    }
}
