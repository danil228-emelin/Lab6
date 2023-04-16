package itmo.p3108;

import itmo.p3108.command.Save;
import itmo.p3108.parser.Parser;
import itmo.p3108.util.CollectionController;
import itmo.p3108.util.FileValidator;
import itmo.p3108.util.ShutDownThread;
import itmo.p3108.util.UserReader;

import java.util.Optional;

public class PrepareServer {

    public void prepare() {
        Save save = new Save();
        ShutDownThread.createAndAdd(save::execute);
        FileValidator fileValidator = new FileValidator();
        String path = fileValidator.findFile();
        Optional<CollectionController> optionalCollectionController = Parser.read(path);
        optionalCollectionController.ifPresent(CollectionController::setController);

        Thread thread = new Thread(() -> {
            while (true) {
                String line = UserReader.readWithoutDollar();
                if (line.equalsIgnoreCase("save")) {
                    save.execute();
                }
            }
        }, "ThreadSave");
        thread.setDaemon(true);
        thread.start();
    }

}
