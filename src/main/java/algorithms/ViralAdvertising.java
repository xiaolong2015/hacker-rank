package algorithms;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author rong.li@mobilexag.de
 */
//https://www.hackerrank.com/challenges/strange-advertising
public class ViralAdvertising {
    public static void main(String[] args) throws FileNotFoundException {
//        final Scanner sc = new Scanner(Paths.get(System.getProperty("user.dir"), "/src/main/resources/viral-advertising.txt").toFile());

        final Scanner sc = new Scanner(System.in);

        int dayNumber = sc.nextInt();
        int[] advertisements = new int[] {5};
        int[] likes = new int[1];
        IntStream.range(0, dayNumber).forEach(i -> {
            likes[0] += advertisements[0] / 2;
            advertisements[0] = advertisements[0] / 2 * 3;
        });
        System.out.println(likes[0]);
    }
}
