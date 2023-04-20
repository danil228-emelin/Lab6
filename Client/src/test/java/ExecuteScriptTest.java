import itmo.p3108.command.ExecuteScript;
import itmo.p3108.util.CollectionController;
import itmo.p3108.util.SerializeObject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExecuteScriptTest {

    ExecuteScript executeScript;
    CollectionController controller;

    @BeforeEach
    public void init() {
        executeScript = new ExecuteScript();
        controller = CollectionController.getInstance();
        controller.getPersonList().clear();
    }


    @Test
    public void check_execute_script() {
        executeScript.prepare("D:\\IntelliJ IDEA 2022.2.3\\Lab6\\Client\\src\\test\\resources\\test_script");
        Assertions.assertThat(SerializeObject.size())
                .as("execute_script doesn't find command")
                .isEqualTo(1);

    }
}
