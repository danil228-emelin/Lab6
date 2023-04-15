package itmo.p3108.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShutDownThread {
    private ShutDownThread() {

    }

    public static void add(Thread thread) {
        Runtime.getRuntime().addShutdownHook(thread);
    }

    public static void createAndAdd(Runnable runnable) {
        Thread thread = new Thread(runnable);
        add(thread);
        log.info("+1 thread executed after main");
    }

}
