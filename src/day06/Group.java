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
        Set<Character> unionSet = new HashSet<>();
        for (Traveller traveller : travellers) {
            unionSet.addAll(traveller.answerSet());
        }
        return (long) unionSet.size();
    }

    public Long getAllYesCount() {
        if (travellers.size() == 0) {
            return 0L;
        }
        // prime the set
        Set<Character> intersectionSet = travellers.get(0).answerSet();

        // this loop goes through the first traveller again, but that's OK because A intersect A = A for every set A
        for (Traveller traveller : travellers) {
            intersectionSet.retainAll(traveller.answerSet());
        }

//        System.out.println("getAnyYesCount is " + intersectionSet.size());
        return (long) intersectionSet.size();
    }

    @Override
    public String toString() {
        return "Group{" + "\n" +
                travellers.stream().map(Traveller::toString).collect(Collectors.joining("\n")) + '\'' +
                '}';
    }
}
