package itmo.p3108;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class UDPReceiver {
    private ByteBuffer buffer = ByteBuffer.allocate(100000);
    private DatagramChannel channel;
    private DatagramSocket socket;
    private InetSocketAddress address;

     public UDPReceiver() throws IOException {
         address = new InetSocketAddress("localhost", 8989);
         channel = DatagramChannel.open();
         socket = channel.socket();
         channel.configureBlocking(false);
         channel.bind(address);
     }
    public void receive () throws IOException, InterruptedException {
        String s = "";
        while (true) {
            Thread.sleep (1000);
            System.out.println ("is waiting");
            InetSocketAddress remoteAdress = (InetSocketAddress) channel.receive(buffer);
            if (remoteAdress != null) {
                buffer.flip();
                int limit = buffer.limit();
                byte bytes[] = new byte[limit];
                buffer.get(bytes, 0, limit);
                s = new String(bytes);
                buffer.clear();
                System.out.println (s);
                return;
            }
        }
    }
}
