package day01;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day01 {
    public static void main(String[] args) {
        System.out.println("Day 1");
        List<Integer> input = puzzleInput();
        part1(input);
        part2(input);
    }

    private static void part1(List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                Integer num1 = input.get(i);
                Integer num2 = input.get(j);
                if (num1 + num2 == 2020) {
                    System.out.printf("Part 1: Numbers are %d and %d and their product is %d%n", num1, num2, num1 * num2);
                }
            }
        }
    }

    private static void part2(List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                for (int k = j + 1; k < input.size(); k++) {
                    Integer num1 = input.get(i);
                    Integer num2 = input.get(j);
                    Integer num3 = input.get(k);
                    if (num1 + num2 + num3 == 2020) {
                        System.out.printf("Part 1: Numbers are %d and %d and %d and their product is %d%n", num1, num2, num3, num1 * num2 * num3);
                    }
                }
            }
        }
    }

    private static List<Integer> puzzleInput() {
        List<Integer> list = new ArrayList<>();
        File file = new File("./day01/input.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                list.add(Integer.parseInt(scanner.nextLine()));
            }
        } catch(Exception e) {
            System.err.println("Error - could not create scanner - stack trace follows:");
            e.printStackTrace();
        }
        return list;
    }
}
