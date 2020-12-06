package day06;

import java.util.HashSet;
import java.util.Set;

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

    public Set<Character> answerSet() {
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < answers.length(); i++) {
            characterSet.add(answers.charAt(i));
        }
        return characterSet;
    }

    @Override
    public String toString() {
        return "Traveller{" +
                "answers='" + answers + '\'' +
                '}';
    }
}
