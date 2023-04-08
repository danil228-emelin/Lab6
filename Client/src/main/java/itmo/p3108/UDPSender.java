package itmo.p3108;

import java.io.IOException;
import java.net.*;

public class UDPSender {
        private DatagramSocket socket;
        private InetAddress address;

        private byte[] buf;

        public UDPSender() throws UnknownHostException, SocketException {
            socket = new DatagramSocket();
            address = InetAddress.getByName("localhost");
        }

        public void sendEcho(String msg) throws IOException {
            buf = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
            socket.send(packet);
        }

        public void close() {
            socket.close();
        }

}
