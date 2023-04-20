package commands;

import itmo.p3108.command.CountByHeight;
import itmo.p3108.model.Person;
import itmo.p3108.util.CollectionController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CountByHeightTest {
    CountByHeight countByHeight;
    CollectionController controller;

    @BeforeEach
    public void init() {
        countByHeight = new CountByHeight();
        controller = CollectionController.getInstance();
    }
    @AfterEach
    public void destruct(){
        controller.getPersonList().clear();
    }
    @Test
    public void check_size_after_addIfMax() {
        Person testPerson = Person.builder().personName("A").personHeight(170d).build();
        controller.add(testPerson);
       countByHeight.setParameter(170d);
        Assertions
                .assertThat(countByHeight.execute())
                .as("CountByHeight doesn't count element")
                .isEqualTo("1");
    }
}
