package itmo.p3108.util;

import itmo.p3108.exception.FileException;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class ServerChanel {
    private static int clientPort=-1;
    UDPReceiver udpReceiver;
    UDPSender udpSender;
    private ConnectionServerState state;

    public ServerChanel(int serverPort) {
        this.state = new ConnectionServerState();
        while (true) {
            try {
                clientPort = (int) (8000 + Math.random() * 2000);
                this.udpReceiver = new UDPReceiver(clientPort);
                break;
            } catch (IllegalArgumentException ignored) {
            }
        }
        this.udpSender = new UDPSender(serverPort);
    }

    public static int getAddress() {
        return clientPort;
    }

    public String sendAndReceive() {
        while (true) {
            if (!state.isHasConnection()) {
                try {
                    System.out.println("Try to get reply for saved messages \n");
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

    public void setState(boolean connectionState) {
        state.setHasConnection(connectionState);
    }
}
