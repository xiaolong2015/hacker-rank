package algorithms.strings;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author rong.li@mobilexag.de
 */
public class CamelCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        if (s == null || s.isEmpty()) {
            System.out.println(0);
        } else {
            int[] wordCount = new int[] {1};
            IntStream.range(0, s.length()).forEach(i -> {
                char c = s.charAt(i);
                if (Character.isUpperCase(c)) {
                    wordCount[0]++;
                }
            } );
            System.out.println(wordCount[0]);
        }
    }
}
