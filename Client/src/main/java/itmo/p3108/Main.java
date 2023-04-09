package itmo.p3108;

import itmo.p3108.parser.Parser;
import itmo.p3108.util.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
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
    public static void main(String[] args) throws IOException, InterruptedException {
        /*UDPSender sender = new UDPSender ();
        sender.sendEcho ("lala");
*/
        UDPReceiver udpReceiver = new UDPReceiver ();
        udpReceiver.receive ();


    }
}
