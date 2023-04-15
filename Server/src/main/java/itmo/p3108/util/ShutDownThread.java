package itmo.p3108.util;

import itmo.p3108.command.FlyWeightCommandFactory;
import itmo.p3108.command.type.Command;

import java.util.Optional;

public class ShutDownThread {
    private ShutDownThread() {

    }

    public static void add(Thread thread) {
        Runtime.getRuntime().addShutdownHook(thread);
    }

    public static void createAndAdd(Runnable runnable) {
        Thread thread = new Thread(runnable);
        add(thread);
    }

}
