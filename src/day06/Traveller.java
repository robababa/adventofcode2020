package day06;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Traveller {
    private String answers;

    public static Traveller fromString(String s) {
        Traveller traveller = new Traveller();
        traveller.answers = s;
        return traveller;
    }

    public Set<Character> answerSet() {
        return IntStream.range(0, answers.length()).mapToObj(i -> answers.charAt(i)).collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return "Traveller{" +
                "answers='" + answers + '\'' +
                '}';
    }
}
