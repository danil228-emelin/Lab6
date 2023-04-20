package commands;

import itmo.p3108.command.FilterStartsWithName;
import itmo.p3108.model.Person;
import itmo.p3108.util.CollectionController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class FilterStartsWithNameTest {
    FilterStartsWithName filterStartsWithName;
    CollectionController controller;

    @BeforeEach
    public void init() {
        filterStartsWithName = new FilterStartsWithName();
        controller = CollectionController.getInstance();
    }
    @AfterEach
    public void destruct(){
        controller.getPersonList().clear();
    }
    @Test
    //@Disabled
    public void check_result_FilterStartsWithName() {
        Person person = Person.builder().personName("D").build();
        controller.getPersonList().add(person);
        filterStartsWithName.setParameter("D");
        Assertions
                .assertThat(filterStartsWithName.execute())
                .describedAs("FilterStartsWithName  doesnt' find element in collection")
                .isNotEmpty();
    }
}
