package itmo.p3108;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Optional;

@Slf4j
/**
 * receive from client.
 */
public class UDPReceiver {
    private DatagramSocket socket;
    private byte[] buf = new byte[10000];

    public UDPReceiver(int ServerPort) {
        try {
            socket = new DatagramSocket(ServerPort);
        } catch (SocketException e) {
            log.error(e.getMessage());
        }
    }

    public Optional<byte[]> receive() {
        try {
            DatagramPacket packet;
            packet = new DatagramPacket(buf, buf.length);
            socket.setSoTimeout(0);
            socket.receive(packet);
            return Optional.of(packet.getData());
        } catch (IOException exception) {
            log.error(exception.getMessage());
            return Optional.empty();
        }

    }

}
