package day04;

import java.util.List;

public class PassportField {
    private String name;
    private String value;

    public static PassportField fromString(String s) {
        PassportField passportField = new PassportField();
        String[] nameAndValue = s.split(":");
        passportField.name = nameAndValue[0];
        passportField.value = nameAndValue[1];
        return passportField;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean valid() {
        switch (this.name) {
            case "byr": return validYear(1920, 2002);
            case "iyr": return validYear(2010, 2020);
            case "eyr": return validYear(2020, 2030);
            case "hgt": return hgtValid();
            case "hcl": return hclValid();
            case "ecl": return eclValid();
            case "pid": return pidValid();
            case "cid": return true;
            default: return false;
        }
    }

    private Boolean validYear(int min, int max) {
        if (!value.matches("^\\d{4}$")) {
            return false;
        }
        int year = Integer.parseInt(this.value);
        return (year >= min && year <= max);
    }

    private Boolean hgtValid() {
//        hgt (Height) - a number followed by either cm or in:
//        If cm, the number must be at least 150 and at most 193.
//        If in, the number must be at least 59 and at most 76.
        if (!this.value.matches("^\\d+(cm|in)$")) {
            return false;
        }
        String units = value.substring(value.length() - 2);
        int num = Integer.parseInt(value.substring(0, value.length() - 2));
        if (units.equals("cm")) {
            return (num >= 150 && num <= 193);
        } else {
            return (num >= 59 && num <= 76);
        }
    }

    private Boolean hclValid() {
        return this.value.matches("^#[0-9a-f]{6}$");
    }

    private Boolean eclValid() {
        return List.of("amb", "blu", "brn", "gry",  "grn", "hzl", "oth").contains(this.value);
    }

    private Boolean pidValid() {
        return this.value.matches("^\\d{9}");
    }

    /*
    byr (Birth Year) - four digits; at least 1920 and at most 2002.
    iyr (Issue Year) - four digits; at least 2010 and at most 2020.
    eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
    hgt (Height) - a number followed by either cm or in:
    If cm, the number must be at least 150 and at most 193.
    If in, the number must be at least 59 and at most 76.
    hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
    ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
    pid (Passport ID) - a nine-digit number, including leading zeroes.
    cid (Country ID) - ignored, missing or not.
     */

}
