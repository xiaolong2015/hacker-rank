package algorithms.strings;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author rong.li@mobilexag.de
 */
public class SimilarStrings {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        final Scanner sc = new Scanner(Paths.get(System.getProperty("user.dir"), "/src/main/resources/similar-strings-2.txt").toFile());

        int len = sc.nextInt();
        int q = sc.nextInt();

        String s = sc.next().substring(0, len);

        String[] searchStrings = new String[q];
        IntStream.range(0, q).forEach(i -> searchStrings[i] = s.substring(sc.nextInt() - 1, sc.nextInt()));

        IntStream.range(0, searchStrings.length).forEach(i -> {
            List<String> subStrings = collectSubString(s, searchStrings[i].length());
            System.out.println(
                    subStrings.stream()
                        .filter(subString -> isSimilar(subString, searchStrings[i]))
                        .count()
            );
        });
    }

    private static boolean isSimilar(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s1.length(); j++) {
                if (i != j &&
                        (s1.charAt(i) == s1.charAt(j) && s2.charAt(i) != s2.charAt(j) ||
                                s1.charAt(i) != s1.charAt(j) && s2.charAt(i) == s2.charAt(j))
                    ) {
                    return false;
                }
            }
        }
        return true;
    }

    private static List<String> collectSubString(String s, int lengthOfSubString) {
        List<String> subStrings = new ArrayList<>();
        int start = 0, end = start + lengthOfSubString;
        while (end <= s.length()) {
            subStrings.add(s.substring(start, end));
            start++;
            end++;
        }
        return subStrings;
    }
}
