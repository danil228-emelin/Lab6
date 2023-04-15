package itmo.p3108;

import itmo.p3108.exception.FileException;
import itmo.p3108.util.SerializeObject;
import lombok.Data;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.Optional;

@Data
public class ConnectionServerState {

    private boolean hasConnection = true;

    public Optional<String> processNormalConnection(UDPSender udpSender, UDPReceiver udpReceiver) {
        byte[] message = SerializeObject.peek();
        udpSender.send(message);
        Optional<InetSocketAddress> inetSocketAddress = udpReceiver.receive();
        if (inetSocketAddress.isEmpty()) {
            hasConnection = false;
            return Optional.empty();
        }
        SerializeObject.remove();
        return Optional.of(createMessage(udpReceiver.getBuffer()));

    }

    public String processLostConnection(UDPSender udpSender, UDPReceiver udpReceiver) {
        byte[] lost_message;
        while (true) {
            lost_message = SerializeObject.peek();
            if (lost_message == null) {
                hasConnection = true;
                return "All messages got reply";
            }
            udpSender.send(lost_message);
            Optional<InetSocketAddress> inetSocketAddress = udpReceiver.receive();
            if (inetSocketAddress.isPresent()) {
                System.out.println(createMessage(udpReceiver.getBuffer()) + "\n");
                SerializeObject.remove();
            } else {
                throw new FileException("Connection with Server lost");

            }
        }

    }

    private String createMessage(ByteBuffer buffer) {
        buffer.flip();
        int limit = buffer.limit();
        byte[] bytes = new byte[limit];
        buffer.get(bytes, 0, limit);
        String message = new String(bytes);
        buffer.clear();
        return message;
    }
}
