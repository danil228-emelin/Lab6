package itmo.p3108.model;



import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

/**
 * class Colour using as  @see {@link Person} eye's color
 */

public enum Color implements Serializable {

    GREEN("1)green"),
    BLUE("2)blue"),
    YELLOW("3)yellow"),
    WHITE("4)white"),
    BROWN("5)brown");
    @Serial
    private static final long serialVersionUID = 489988001L;
    private final String name;

    Color(String name) {
        this.name = name;
    }

    public static Optional<Color> newValue(String str) {
        for (Color color : Color.values()) {
            if (color.getName().startsWith(str))
                return Optional.of(color);
        }
        return Optional.empty();

    }

    /**
     * @param test by id check whether enum constant exist or not
     */
    public static boolean isPresent(String test) {
        for (Color color : Color.values()) {
            if (color.getName().substring(2).equals(test.toLowerCase())) {

                return true;
            }

        }
        return false;
    }

    /**
     * @return all constants converted to String
     */
    public static String[] colors() {
        return Arrays.stream(Color.values()).map(Color::getName).toArray(String[]::new);
    }

    public String getName() {
        return name;
    }
}
