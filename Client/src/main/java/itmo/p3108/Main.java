package itmo.p3108;

import itmo.p3108.util.Invoker;
import itmo.p3108.util.UserReader;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
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
    public static void main(String[] args) throws IOException {

        UDPSender sender = new UDPSender(4445);
        UDPReceiver udpReceiver = new UDPReceiver(8989);
        Invoker invoker = Invoker.getInstance();
        while (true) {
            Optional<byte[]> serializedCommand = invoker.invoke(UserReader.read());
            serializedCommand.ifPresentOrElse(sender::send, () -> {
                System.err.println("Can't send to server  ");
            });
            System.out.println(udpReceiver.receive());
        }
    }
}
