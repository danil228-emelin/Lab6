package itmo.p3108.util;

import itmo.p3108.adapter.ZonedDateAdapter;

import java.time.ZonedDateTime;

public class Test {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        String zonedString = ZonedDateAdapter.getInstance().marshal(zonedDateTime);
        ZonedDateTime marshaled = ZonedDateTime.parse(zonedString);
        System.out.println(marshaled);
    }
}
