package itmo.p3108;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiver {
    private DatagramSocket socket;
    private byte[] buf = new byte[256];

    public UDPReceiver () throws SocketException {
        socket = new DatagramSocket (4445);
    }

    public void receive () throws IOException {
        DatagramPacket packet;
        packet = new DatagramPacket (buf, buf.length);
        socket.setSoTimeout (500000);
        socket.receive (packet);
        String received = new String (packet.getData (), 0, packet.getLength ());
        System.out.println (received);
    }

}
