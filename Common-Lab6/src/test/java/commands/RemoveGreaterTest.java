package commands;

import itmo.p3108.command.RemoveGreater;
import itmo.p3108.model.Person;
import itmo.p3108.util.CollectionController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class RemoveGreaterTest {

    RemoveGreater removeGreater;
    CollectionController controller;

    @BeforeEach
    public void init() {
        removeGreater = new RemoveGreater();
        controller = CollectionController.getInstance();
    }
    @AfterEach
    public void destruct(){
        controller.getPersonList().clear();
    }
    @Test
    public void check_test() {
        Person person1 = Person.builder().personName("B").personBirthday(LocalDate.now()).build();
        Person person2 = Person.builder().personName("A").personBirthday(LocalDate.now()).build();
        Person person3 = Person.builder().personName("C").personBirthday(LocalDate.now()).build();
        controller.getPersonList().add(person1);
        controller.getPersonList().add(person3);
        removeGreater.setParameter(person2);
        removeGreater.execute();
        Assertions.assertThat(controller.getPersonList().size())
                .as("RemoveGreater doesn't delete elements")
                .isEqualTo(0);

    }
}
