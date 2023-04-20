package commands;

import itmo.p3108.command.AddIfMax;
import itmo.p3108.model.Person;
import itmo.p3108.util.CollectionController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddIfMaxTest {

    AddIfMax addIfMax;
    CollectionController controller;

    @BeforeEach
    public void init() {
        addIfMax = new AddIfMax();
        controller = CollectionController.getInstance();
    }

    @AfterEach
    public void destruct() {
        controller.getPersonList().clear();
    }

    @Test
    public void check_size_after_addIfMax() {
        Person testPerson = Person.builder().personName("A").personHeight(170.0).build();
        controller.getPersonList().add(testPerson);
        Person person1 = Person.builder().personName("B").personHeight(182.0).build();
        addIfMax.setParameter(person1);
        addIfMax.execute();
        addIfMax.execute();
        Assertions
                .assertThat(controller.getPersonList()
                        .size()).as("AddIfMax  doesn't add element in collection")
                .isEqualTo(2);

    }
}
