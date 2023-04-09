package itmo.p3108;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.*;

@Slf4j
public class UDPSender {
    private DatagramSocket socket;
    private InetAddress address;
    private int serverPort;
    private byte[] buf;

    public UDPSender(int serverPort) {
        try {
            this.serverPort = serverPort;
            socket = new DatagramSocket();
            address = InetAddress.getByName("localhost");
        } catch (SocketException | UnknownHostException exception) {
            log.error(exception.getMessage());
        }

    }

    public void send(String msg) {
        try {
            buf = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, serverPort);
            socket.send(packet);

        } catch (IOException exception) {
            log.error(exception.getMessage());

        }

    }

    public void send(byte[] msg) {
        try {
            buf = msg;
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, serverPort);
            socket.send(packet);
        } catch (IOException exception) {
            exception.printStackTrace();
            log.error(exception.getMessage());
        }

    }

    public void close() {
        socket.close();
    }

}
