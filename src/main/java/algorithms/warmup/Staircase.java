package algorithms.warmup;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author rong.li@mobilexag.de
 */
public class Staircase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        IntStream.range(0, len)
            .forEach(i ->
                {
                    IntStream.range(0, len)
                        .forEach(j -> System.out.print((i + j < len - 1) ? " " : "#"));
                    System.out.println();
                }
            );
    }
}