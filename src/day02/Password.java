package day02;

public class Password {
    private int minimum;
    private int maximum;
    private String givenLetter;
    private String password;

    public static Password stringToPassword(String s) {
        Password password = new Password();
        String formatted = s.replaceAll("-", " ").replaceAll(":", "");
        String[] parts = formatted.split(" ");
        password.minimum = Integer.parseInt(parts[0]);
        password.maximum = Integer.parseInt(parts[1]);
        password.givenLetter = parts[2];
        password.password = parts[3];
        return password;
    }

    public Boolean isValidPart1() {
        int occurrences = this.password.replaceAll("[^" + this.givenLetter + "]", "").length();
        return (occurrences >= this.minimum && occurrences <= this.maximum);
    }

    public Boolean isValidPart2() {
        return String.valueOf(this.password.charAt(minimum - 1)).equals(givenLetter) ^
                String.valueOf(this.password.charAt(maximum - 1)).equals(givenLetter);
    }

    @Override
    public String toString() {
        return "Password{" +
                "minimum=" + minimum +
                ", maximum=" + maximum +
                ", givenLetter='" + givenLetter + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
