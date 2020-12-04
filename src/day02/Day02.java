package day02;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static common.PuzzleInput.puzzleInput;

public class Day02 {
    public static void main(String[] args) {
        System.out.println("Day 2");
        List<String> input = puzzleInput("./day02/input.txt");
        List<Password> passwords = input
                .stream()
                .map(Password::stringToPassword)
                .collect(Collectors.toUnmodifiableList());
        printValidCount(passwords, Password::isValidPart1, "Part 1");
        printValidCount(passwords, Password::isValidPart2, "Part 2");
    }

    private static void printValidCount(List<Password> passwords, Predicate<Password> filter, String label) {
        System.out.printf(label + ": There are %d validPart1 passwords%n", passwords.stream().filter(filter).count());
    }
}
