package algorithms.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @author rong.li@mobilexag.de
 */
// https://www.hackerrank.com/challenges/two-characters
public class TwoCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        String s = sc.next();

        if (len < s.length()) {
            s = s.substring(0, len);
        }
        char[] charArray = s.toCharArray();
        List<Integer> distinctCharAsInt = new ArrayList<>();
        IntStream.range(0, charArray.length).forEach(i -> {
            if (!distinctCharAsInt.contains(charArray[i])) {
                distinctCharAsInt.add((int) charArray[i]);
            }
        });
        int result = 0;
        if (distinctCharAsInt.size() > 1) {
            for (int i = 0; i < distinctCharAsInt.size() - 1; i++) {
                for (int j = i + 1; j < distinctCharAsInt.size(); j++) {
                    StringBuilder candidate = new StringBuilder();
                    for (int n = 0; n < charArray.length; n++) {
                        char c = charArray[n];
                        char letter1 = (char) distinctCharAsInt.get(i).intValue();
                        char letter2 = (char) distinctCharAsInt.get(j).intValue();
                        if (c == letter1 || c == letter2) {
                            candidate.append(c);
                        }
                        if (candidate.length() > 1 && candidate.charAt(candidate.length() - 2) == candidate.charAt(candidate.length() - 1)) {
                            candidate = new StringBuilder(); // reset
                            break;
                        }
                    }
                    if (candidate.length() > 1 && result < candidate.length()) {
                        result = candidate.length();
                    }
                }
            }
        }
        System.out.println(result);
    }
}
