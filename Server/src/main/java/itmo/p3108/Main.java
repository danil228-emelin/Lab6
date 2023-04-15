package itmo.p3108;

import itmo.p3108.command.Save;
import itmo.p3108.parser.Parser;
import itmo.p3108.util.CollectionController;
import itmo.p3108.util.Executor;
import itmo.p3108.util.FileValidator;
import itmo.p3108.util.ShutDownThread;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * Entry point of program
 * Before working with user,
 * FileValidator check whether the xml file for serialization and deserialization has added
 * Parser try to download elements from xml file
 * Checkdata check all person attributes.
 * Invoker using getInstance download all existing commands.
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        Save save = new Save();
        ShutDownThread.createAndAdd(save::execute);
        FileValidator fileValidator = new FileValidator();
        String path = fileValidator.findFile();
        Optional<CollectionController> optionalCollectionController = Parser.read(path);
        optionalCollectionController.ifPresent(CollectionController::setController);

        UDPSender udpSender = new UDPSender();
        UDPReceiver udpReceiver = new UDPReceiver(4445);
        while (true) {
            Executor.executeCommand(udpSender, udpReceiver);
        }

    }
}
