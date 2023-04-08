package itmo.p3108;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
public class UDPSender {
    private boolean isCommandWithObject;
    private InetSocketAddress serverAddress;
    private final ByteBuffer buffer = ByteBuffer.allocate(100000);
    private DatagramChannel channel;
    public UDPSender () throws IOException {
        channel = DatagramChannel.open ();
        channel.bind(null);
        serverAddress = new InetSocketAddress("localhost", 8989);
        channel.configureBlocking(false);
    }

    public  void send() throws IOException {
        buffer.clear();
        buffer.put("serverToClient".getBytes());
        buffer.flip();
        channel.send(buffer, serverAddress);
        buffer.flip();
        }
}
