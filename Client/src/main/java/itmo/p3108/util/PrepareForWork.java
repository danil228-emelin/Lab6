package itmo.p3108.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PrepareForWork {

    public static void restoreLostCommands() {
        String key = "lost commands";
        try (Jedis jedis = new Jedis()) {
            byte[] serializedMessage;
            while (true) {
                serializedMessage = jedis.rpop(key.getBytes());
                if (serializedMessage == null) {
                    jedis.del(key);
                    log.info("lost commands restored");
                    return;
                }
                SerializeObject.add(serializedMessage);
            }

        } catch (JedisConnectionException exception) {
            log.error("can't make connection with Jedis server,lost commands can't be restore");
        }

    }
}
