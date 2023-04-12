package itmo.p3108.util;

import itmo.p3108.ConnectionServerState;
import itmo.p3108.UDPReceiver;
import itmo.p3108.UDPSender;
import itmo.p3108.exception.FileException;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class ServerChanel {
    UDPReceiver udpReceiver;
    UDPSender udpSender;
    private ConnectionServerState state;

    public ServerChanel(int clientPort, int serverPort) {
        this.state = new ConnectionServerState();
        this.udpReceiver = new UDPReceiver(clientPort);
        this.udpSender = new UDPSender(serverPort);
    }

    public String sendAndReceive() {
        while (true) {
            if (!state.isHasConnection()) {
                try {
                    System.out.println("Try to get reply for lost messages \n");
                    return state.processLostConnection(udpSender, udpReceiver);
                } catch (FileException exception) {
                    log.error(exception.getMessage());
                    return "Connection with server lost,all messages saved";
                }
            }
            Optional<String> reply = state.processNormalConnection(udpSender, udpReceiver);
            if (reply.isPresent()) {
                return reply.get();
            }
        }
    }

    public int getAddress() {
        return udpReceiver.getAddress();
    }


}
