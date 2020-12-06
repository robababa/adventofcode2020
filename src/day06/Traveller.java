package day06;

public class Traveller {
    private String answers;

    public static Traveller fromString(String s) {
        Traveller traveller = new Traveller();
        traveller.answers = s;
        return traveller;
    }

    public String getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return "Traveller{" +
                "answers='" + answers + '\'' +
                '}';
    }
}
