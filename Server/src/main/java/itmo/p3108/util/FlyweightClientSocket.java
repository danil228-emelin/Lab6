package itmo.p3108.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FlyweightClientSocket {
    private static final Map<String, InetSocketAddress> CLIENT_SOCKET = new HashMap<>();



    public static InetSocketAddress getClientSocket(String clientPort) {
        if (CLIENT_SOCKET.containsKey(clientPort)) {
            return CLIENT_SOCKET.get(clientPort);
        }
        InetSocketAddress clientAddress = new InetSocketAddress("localhost", Integer.parseInt(clientPort));
        CLIENT_SOCKET.put(clientPort, clientAddress);
        return clientAddress;
    }

}
