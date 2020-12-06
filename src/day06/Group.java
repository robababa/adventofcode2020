package day06;

import java.util.*;
import java.util.stream.Collectors;

public class Group {
    private List<Traveller> travellers = new ArrayList<>();

    public static Group fromTravellers(List<Traveller> travellers) {
        Group group = new Group();
        group.travellers = travellers;
        return group;
    }

    public Long getAnyYesCount() {
        String allAnswers = travellers.stream().map(Traveller::getAnswers).collect(Collectors.joining());
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < allAnswers.length(); i++) {
            characterSet.add(allAnswers.charAt(i));
        }
        return (long) characterSet.size();
    }

    private void populateSet(HashSet<Character> set, String answers) {
        for (int i = 0; i < answers.length(); i++) {
            set.add(answers.charAt(i));
        }
    }

    public Long getAllYesCount() {
        if (travellers.size() == 0) {
            return 0L;
        }
        HashSet<Character> originalSet = new HashSet<>();

        //prime the list with the first traveller
        String firstTravellerAnswers = travellers.get(0).getAnswers();
        populateSet(originalSet, firstTravellerAnswers);

        // now go through the rest of the travellers
        HashSet<Character> nextSet = new HashSet<>();
        for (int travellerIndex = 1; travellerIndex < travellers.size(); travellerIndex++) {
            String nextAnswers = travellers.get(travellerIndex).getAnswers();
            populateSet(nextSet, nextAnswers);
            originalSet.retainAll(nextSet);
            nextSet.clear();
        }

        return (long) originalSet.size();
    }

    @Override
    public String toString() {
        return "Group{" + "\n" +
                travellers.stream().map(Traveller::toString).collect(Collectors.joining("\n")) + '\'' +
                '}';
    }
}
