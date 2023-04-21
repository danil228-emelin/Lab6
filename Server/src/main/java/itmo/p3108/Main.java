package itmo.p3108;

import itmo.p3108.util.Executor;
import itmo.p3108.util.UDPReceiver;
import itmo.p3108.util.UDPSender;
import lombok.extern.slf4j.Slf4j;

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
        PrepareServer prepareServer = new PrepareServer();
        prepareServer.prepare();
        UDPSender udpSender = new UDPSender();
        UDPReceiver udpReceiver = new UDPReceiver(4445);
        while (true) {
            Executor.executeCommand(udpSender, udpReceiver);
        }

    }
}
