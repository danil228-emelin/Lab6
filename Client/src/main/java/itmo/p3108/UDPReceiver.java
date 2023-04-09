package itmo.p3108;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

@Slf4j
public class UDPReceiver {
    private ByteBuffer buffer = ByteBuffer.allocate(100000);
    private DatagramChannel channel;
    private DatagramSocket socket;
    private InetSocketAddress address;

    public UDPReceiver(int clientPort) {
        try {
            address = new InetSocketAddress("localhost", clientPort);
            channel = DatagramChannel.open();
            socket = channel.socket();
            channel.configureBlocking(false);
            channel.bind(address);
        } catch (IOException exception) {
            log.error(exception.getMessage());
        }

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String receive() {
        String s = "";
        while (true) {
            InetSocketAddress receiver = null;
            try {
                receiver = (InetSocketAddress) channel.receive(buffer);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
            if (receiver != null) {
                buffer.flip();
                int limit = buffer.limit();
                byte bytes[] = new byte[limit];
                buffer.get(bytes, 0, limit);
                s = new String(bytes);
                buffer.clear();
                return s;
            }
        }
    }

    public int getAddress() {
        return address.getPort();
    }
}
