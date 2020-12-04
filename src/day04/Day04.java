package day04;

import java.util.ArrayList;
import java.util.List;

import static common.PuzzleInput.puzzleInput;

public class Day04 {
    public static void main(String[] args) {
        System.out.println("Day 4");
        String inputFileName = args[0];
        List<String> input = puzzleInput(inputFileName);
        List<Passport> passports = buildPassports(input);
        System.out.printf("Part 1: There are %d valid passports.%n", part1(passports));
        System.out.printf("Part 2: There are %d valid passports.%n", part2(passports));
    }

    private static List<Passport> buildPassports(List<String> input) {
        List<Passport> passports = new ArrayList<>();
        StringBuilder s = new StringBuilder();

        for (String line : input) {
            if (line.equals("")) {
                passports.add(Passport.fromString(s.toString()));
                s = new StringBuilder();
            } else if (s.length() == 0) {
                s.append(line);
            } else {
                s.append(" ").append(line);
            }
        }

        // finish the last passport
        passports.add(Passport.fromString(s.toString()));
        return passports;
    }

    private static long part1(List<Passport> passports) {
        return passports.stream().filter(Passport::validPart1).count();
    }

    private static long part2(List<Passport> passports) {
        return passports.stream().filter(Passport::validPart2).count();
    }
}
