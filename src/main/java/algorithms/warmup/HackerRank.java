package algorithms.warmup;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author rong.li@mobilexag.de
 */
public class HackerRank {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] sum = new int[] {0};
        IntStream.range(0, len).forEach(i -> sum[0] += sc.nextInt());
        System.out.println(sum[0]);*/

        /*Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        int[] scores = new int[] {a0 - b0, a1 - b1, a2 - b2};
        int[] result = new int[2];
        result[0] =
                (scores[0] > 0 ? 1 : 0) +
                (scores[1] > 0 ? 1 : 0) +
                (scores[2] > 0 ? 1 : 0);
        result[1] =
                (scores[0] < 0 ? 1 : 0) +
                        (scores[1] < 0 ? 1 : 0) +
                        (scores[2] < 0 ? 1 : 0);
        System.out.println(result[0] + " " + result[1]);*/

        /*Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        long[] sum = new long[] {0};
        IntStream.range(0, len).forEach(i -> sum[0] += (long) sc.nextInt());
        System.out.println(sum[0]);*/

        /*Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[][] matrix = new int[len][len];
        IntStream.range(0, len)
                .forEach(
                        i -> IntStream.range(0, len)
                                .forEach(j -> matrix[i][j] = sc.nextInt())
                );
        long[] sum = new long[] {0L, 0L};
        IntStream.range(0, len)
                .forEach(i -> sum[0] += matrix[i][i]);
        IntStream.range(0, len)
                .forEach(i -> sum[1] += matrix[i][(len - 1) - i]);
        System.out.println(Math.abs(sum[0] - sum[1]));*/

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] counter = new int[] {0, 0, 0};
        IntStream.range(0, len)
                .forEach(
                        i -> {
                            int number = sc.nextInt();
                            if (number > 0) counter[0]++;
                            if (number < 0) counter[1]++;
                            if (number == 0) counter[2]++;
                        }
                );
        IntStream.range(0, counter.length)
                .forEach(
                        i -> System.out.format("%.6f%n",
                                BigDecimal.valueOf(counter[i])
                                    .divide(BigDecimal.valueOf(len), 6, RoundingMode.HALF_UP).doubleValue())
                );
    }
}
