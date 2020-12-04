package day04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Passport {
    private List<PassportField> fields;

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
        String[] stringFields = s.split(" ");
//        System.out.println("  in Passport.fromString: stringFields are " + Arrays.toString(stringFields));
        passport.fields = Arrays.stream(stringFields).map(PassportField::fromString).collect(Collectors.toList());
        return passport;
    }

    public Boolean validPart1() {
        return fields.stream().map(PassportField::getName).collect(Collectors.toList()).containsAll(requiredFields);
    }

    public Boolean validPart2() {
        return validPart1() && fields.stream().allMatch(PassportField::valid);
    }
}
