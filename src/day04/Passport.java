package day04;

import java.util.Arrays;
import java.util.List;

public class Passport {
    private List<String> fields;

    private static List<String> requiredFields = List.of(
            "byr",
            "iyr",
            "eyr",
            "hgt",
            "hcl",
            "ecl",
            "pid"
    );



    public static Passport fromString(String s) {
        Passport passport = new Passport();
        String[] stringFields = s.replaceAll(":[^ ]+", "").split(" ");
//        System.out.println("  in Passport.fromString: stringFields are " + Arrays.toString(stringFields));
        passport.fields = Arrays.asList(stringFields);
        return passport;
    }

    public Boolean valid() {
        return fields.containsAll(requiredFields);
    }
}
