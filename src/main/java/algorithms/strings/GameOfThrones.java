package algorithms.strings;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameOfThrones {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        Map<Integer, Integer> letterCounter = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            Integer counter = letterCounter.get((int) input.charAt(i));
            if (counter == null) {
                counter = 1;
            }
            else {
                counter = counter.intValue() + 1;
            }
            letterCounter.put((int) input.charAt(i), counter);
        }
        long countOfEvenNumberLetters = letterCounter.values()
                                                     .stream()
                                                     .filter(counter -> counter.intValue() % 2 == 0 && counter.intValue() / 2 > 0)
                                                     .count();
        long countOfOddNumberLetters = letterCounter.values()
                                                    .stream()
                                                    .filter(counter -> counter.intValue() % 2 != 0)
                                                    .count();
        System.out.println(countOfEvenNumberLetters > 0 && countOfOddNumberLetters < 2 ? "YES" : "NO");
    }
}
