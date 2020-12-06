package day06;

import java.util.ArrayList;
import java.util.List;

import static common.PuzzleInput.puzzleInput;

public class Day06 {
    public static void main(String[] args) {
        System.out.println("Day 6");
        String inputFileName = args[0];
        List<String> input = puzzleInput(inputFileName);
        List<Group> groups = buildGroups(input);
//        for (Group group : groups) {
//            System.out.println(group);
//        }
        System.out.printf("Part 1: Sum of ANY yes in group counts is %d.%n", part1(groups));
        System.out.printf("Part 2: Sum of ALL yes in group counts is %d.%n", part2(groups));
    }

    private static List<Group> buildGroups(List<String> stringList) {
        List<Group> groups = new ArrayList<>();
        List<Traveller> travellers = new ArrayList<>();
        for (String s: stringList) {
            if (s.length() == 0 && travellers.size() > 0) {
                groups.add(Group.fromTravellers(travellers));
                travellers = new ArrayList<>();
            } else {
                travellers.add(Traveller.fromString(s));
            }
        }
        // get the last group
        if (travellers.size() > 0) {
            groups.add(Group.fromTravellers(travellers));
        }
        return groups;
    }

    private static Long part1(List<Group> groups) {
        return groups.stream().map(Group::getAnyYesCount).reduce(0L, Long::sum);
    }

    private static Long part2(List<Group> groups) {
        return groups.stream().map(Group::getAllYesCount).reduce(0L, Long::sum);
        // 3347 is too low
    }
}
