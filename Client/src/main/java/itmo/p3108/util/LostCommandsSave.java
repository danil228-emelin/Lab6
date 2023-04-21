package itmo.p3108.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LostCommandsSave {

    public static void createConnectionAndSave() {
        String key = "lost commands";
        try (Jedis jedis = new Jedis()) {
            byte[] serializedMessage;
            while (true) {
                serializedMessage = SerializeObject.peek();
                if (serializedMessage == null) {
                    log.info("all lost commands saved");
                    return;
                }
                SerializeObject.remove();
                jedis.lpush(key.getBytes(), serializedMessage);
            }

        } catch (JedisConnectionException exception) {
            log.error("can't make connection with Jedis server,lost commands");
        }

    }
}
