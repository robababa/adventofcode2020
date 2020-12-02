package common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PuzzleInput {
    public static List<String> puzzleInput(String filename) {
        List<String> list = new ArrayList<>();
        File file = new File(filename);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        } catch(Exception e) {
            System.err.println("Error - could not create scanner - stack trace follows:");
            e.printStackTrace();
        }
        return list;
    }
}
