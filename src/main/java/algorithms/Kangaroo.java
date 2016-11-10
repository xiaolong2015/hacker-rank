package algorithms;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author rong.li@mobilexag.de
 */
public class Kangaroo {
    // https://www.hackerrank.com/challenges/kangaroo?h_r=next-challenge&h_v=zen
    public static void main(String[] args) throws FileNotFoundException {
//        final Scanner sc = new Scanner(Paths.get(System.getProperty("user.dir"), "/src/main/resources/kangaroo-2.txt").toFile());

        final Scanner sc = new Scanner(System.in);
        int start1 = sc.nextInt();
        int jumpDistance1 = sc.nextInt();
        int start2 = sc.nextInt();
        int jumpDistance2 = sc.nextInt();

        if (jumpDistance1 <= jumpDistance2) {
            System.out.println("NO");
        }
        else if (start1 + jumpDistance1 > start2 + jumpDistance2) {
            System.out.println("NO");
        }
        else {
            int speed = Math.abs(start1 - start2) - Math.abs(start1 + jumpDistance1 - (start2 + jumpDistance2));
            if (Math.abs(start1 - start2) % speed == 0) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
