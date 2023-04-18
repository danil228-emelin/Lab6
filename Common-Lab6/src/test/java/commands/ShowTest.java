package commands;

import itmo.p3108.command.RemoveGreater;
import itmo.p3108.command.Show;
import itmo.p3108.model.Person;
import itmo.p3108.util.CollectionController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShowTest {
        Show show;
        CollectionController controller;

        @BeforeEach
        public void init() {
            show = new Show();
            controller = CollectionController.getInstance();
        } @AfterEach
    public void destruct(){
        controller.getPersonList().clear();
    }

        @Test
        public void check_test() {
            Person person1 = Person.builder().personName("B").build();
            Person person2 = Person.builder().personName("A").build();
            controller.getPersonList().add(person1);
            controller.getPersonList().add(person2);
            Assertions
                    .assertThat(show.execute())
                    .as("show doesn't show elements")
                    .containsPattern("Person\\{[\\s\\S]+Person\\{");

        }
    }

