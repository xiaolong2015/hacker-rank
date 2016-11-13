package algorithms.strings;

import java.util.Scanner;

/**
 * @author rong.li@mobilexag.de
 */
// https://www.hackerrank.com/challenges/pangrams?h_r=next-challenge&h_v=zen
public class Pangrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        final String lowerCaseString = s.toLowerCase();
        long letterCount = lowerCaseString.chars().distinct()
                .filter(i -> i >= 'a' && i <= 'z' && i != ' ')
                .count();
        if (letterCount == 26)
            System.out.println("pangram");
        else
            System.out.println("not pangram");
    }
}
