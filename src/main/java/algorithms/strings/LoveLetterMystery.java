package algorithms.strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

public class LoveLetterMystery {
    public static void main(String[] args) throws FileNotFoundException {
        final File input = Paths
                .get(System.getProperty("user.dir"), "/src/main/resources/love-letter-mystery.txt")
                .toFile();
        Scanner sc = new Scanner(input);

        Function<char[], Boolean> isPalindrome = letters -> {
            for (int i = 0; i < letters.length / 2; i++) {
                if (letters[i] != letters[letters.length - 1 - i]) {
                    return false;
                }
            }
//            System.out.println(String.valueOf(letters));
            return true;
        };

        BiFunction<char[], int[], char[]> reduceLetterValue = (letters, count) -> {
            // search for the biggest diff between tow letters
            int maxDiff = 0;
            for (int i = 0; i < letters.length / 2; i++) {
                int diff = letters[letters.length - 1 - i] - letters[i];
                if (diff < 0 && (-diff) > maxDiff) {
                    maxDiff = (-diff);
                }
                if (diff > 0 && diff > maxDiff) {
                    maxDiff = diff;
                }
            }
            for (int i = 0; i < letters.length / 2; i++) {
                int diff = letters[letters.length - 1 - i] - letters[i];
                if (diff < 0 && (-diff) == maxDiff) {
                    letters[i] = (char) (letters[i] - 1);
                    count[0]++;
                }
                if (diff > 0 && diff == maxDiff) {
                    letters[letters.length - 1 - i] = (char) (letters[letters.length - 1 - i] - 1);
                    count[0]++;
                }
            }
            return letters;
        };

        Consumer<char[]> printMinOperation = letters -> {
            if (isPalindrome.apply(letters)) {
                System.out.println(0);
            }
            else {
                int[] counter = new int[] {0};
                char[] reducedLetters = reduceLetterValue.apply(letters, counter);
                while (!isPalindrome.apply(reducedLetters)) {
                    reducedLetters = reduceLetterValue.apply(reducedLetters, counter);
                }
                System.out.println(counter[0]);
            }
        };

        int count = sc.nextInt();
        IntStream.range(0, count).forEach(i -> printMinOperation.accept(sc.next().toCharArray()));
    }
}
