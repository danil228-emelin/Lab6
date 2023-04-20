import itmo.p3108.command.Save;
import itmo.p3108.model.Person;
import itmo.p3108.parser.Parser;
import itmo.p3108.util.CollectionController;
import itmo.p3108.util.FileValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class SaveTest {
    FileValidator fileValidator;
    Save save;

    private void collectionCleanAndSave() {
        CollectionController.getInstance().getPersonList().clear();
        save.execute();

    }

    @BeforeEach
    void clear() {
        fileValidator = new FileValidator();
        save = new Save();
        collectionCleanAndSave();
    }

    @Test
    public void check_save() {
        Person test = Person.builder().build();
        CollectionController.getInstance().getPersonList().add(test);
        save.execute();
        String path = fileValidator.findFile();
        Optional<CollectionController> optionalCollectionController = Parser.read(path);
        optionalCollectionController.ifPresent(CollectionController::setController);

        Assertions
                .assertThat(CollectionController.getInstance().getPersonList().size())
                .as("Save doesn't save elements from collection")
                .isEqualTo(1);

    }
}
