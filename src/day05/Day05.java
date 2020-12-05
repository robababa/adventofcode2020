package day05;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static common.PuzzleInput.puzzleInput;

public class Day05 {
    public static void main(String[] args) {
        System.out.println("Day 5");
        String inputFileName = args[0];
        List<String> input = puzzleInput(inputFileName);
        List<Seat> seats = input.stream().map(Seat::fromString).collect(Collectors.toList());
        System.out.printf("Part 1: The highest seat ID is %d.%n", part1(seats));
        System.out.printf("Part 2: Your seat ID is %d.%n", part2(seats));
    }

    private static Integer part1(List<Seat> seats) {
        return seats.stream().map(Seat::seatNumber).max(Integer::compareTo).get();
    }


    private static Integer part2(List<Seat> seats) {
        List<Integer> seatNumbers =
                seats.stream().map(Seat::seatNumber).sorted(Integer::compareTo).collect(Collectors.toList());
        // cheesy - initialize fake seat to prime the loop
        int lastSeatNumber = -2;
        for (Integer currentNumber : seatNumbers) {
            if (currentNumber == lastSeatNumber + 2) {
                return currentNumber - 1;
            } else {
                lastSeatNumber = currentNumber;
            }
        }
        // cheesy - return fake answer if loop doesn't find one
        return -42;
    }
}
