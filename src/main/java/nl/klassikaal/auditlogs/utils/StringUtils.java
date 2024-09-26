package nl.klassikaal.auditlogs.utils;

import java.util.Random;

public class StringUtils {

    private StringUtils() {
    }

    private static final String[] FIRST_NAMES = {
            "John", "Jane", "Alex", "Emily", "Chris", "Katie", "Michael", "Sarah", "David", "Laura"
    };

    private static final String[] LAST_NAMES = {
            "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez"
    };

    private static final Random RANDOM = new Random();

    public static String generateRandomFirstname() {
        return FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)];
    }

    public static String generateRandomLastname() {
        return LAST_NAMES[RANDOM.nextInt(LAST_NAMES.length)];
    }

    public static String generateRandomEmail() {
        return generateRandomFirstname().toLowerCase() + "." + generateRandomLastname().toLowerCase() + "@example.com";
    }

    public static String generateRandomPhonenumber() {
        return "06" + (10000000 + RANDOM.nextInt(90000000));
    }
}
