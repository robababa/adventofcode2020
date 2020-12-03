package day03;

import java.util.List;

import static common.PuzzleInput.puzzleInput;

public class Day03 {
    public static void main(String[] args) {
        System.out.println("Day 3");
        String inputFileName = args[0];
        List<String> input = puzzleInput(inputFileName);
        System.out.printf("Part 1: You hit %d trees.%n", treeCount(input, 3, 1));
        System.out.printf("Part 2: Product of trees hit with various slopes is %d.%n", part2(input));
    }

    private static long part2(List<String> input) {
        long hit1 = treeCount(input, 1, 1);
        long hit2 = treeCount(input, 3, 1);
        long hit3 = treeCount(input, 5, 1);
        long hit4 = treeCount(input, 7, 1);
        long hit5 = treeCount(input, 1, 2);
        return hit1 * hit2 * hit3 * hit4 * hit5;
    }

    private static long treeCount(List<String> input, int right, int down) {
        System.out.println("Right: " + right + " Down: " + down);
        long trees = 0;
        int column = 0;
        for (int row = 0; row < input.size(); row = row + down) {
//            System.out.println("Checking row " + (row+1) + " column " + column);
            if (input.get(row).charAt(column) == '#') {
                trees++;
            }
            column = (column + right) % input.get(0).length();
        }
        return trees;
    }
}
