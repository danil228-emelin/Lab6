package itmo.p3108;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;

@Slf4j
public class UDPSender {
    private DatagramSocket socket;
    private InetAddress address;
    private  int serverPort;

    public UDPSender(int serverPort) {
        try {
            this.serverPort = serverPort;
            socket = new DatagramSocket();
            address = InetAddress.getByName("localhost");
        } catch (SocketException | UnknownHostException exception) {
            log.error(exception.getMessage());
            System.exit(1);
        }

    }

    public void send(String msg) {
        try {
            byte[] buf = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, serverPort);
            socket.send(packet);

        } catch (IOException exception) {
            log.error(exception.getMessage());

        }

    }

    public void send(byte[] msg) {
        try {
            ByteBuffer buffer = ByteBuffer.wrap(msg);
            DatagramPacket packet = new DatagramPacket(buffer.array(), buffer.limit(), address, serverPort);
            socket.send(packet);
        } catch (IOException exception) {
            System.err.println("Can't send message to server");
            log.error(exception.getMessage());
        }

    }

    public void close() {
        socket.close();
    }

}
