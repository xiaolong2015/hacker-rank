package algorithms;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author rong.li@mobilexag.de
 */
public class AppleAndOrange {
    public static void main(String[] args) throws FileNotFoundException {
//        final Scanner sc = new Scanner(Paths.get(System.getProperty("user.dir"), "/src/main/resources/apple-orange.txt").toFile());
        final Scanner sc = new Scanner(System.in);
        int houseLeft = sc.nextInt();
        int houseRight = sc.nextInt();

        int appleTreeX = sc.nextInt();
        int orangeTreeX = sc.nextInt();

        int appleNumber = sc.nextInt();
        int orangeNumber = sc.nextInt();

        int[] appleX = new int[appleNumber];
        int[] orangeX = new int[orangeNumber];

        IntStream.range(0, appleX.length).forEach(i -> appleX[i] = sc.nextInt());
        IntStream.range(0, orangeX.length).forEach(i -> orangeX[i] = sc.nextInt());

        System.out.println(
            IntStream.range(0, appleX.length)
                .filter(i -> appleX[i] > 0 && appleTreeX + appleX[i] >= houseLeft && appleTreeX + appleX[i] <= houseRight)
                .count());
        System.out.println(
            IntStream.range(0, orangeX.length)
                .filter(i -> orangeX[i] < 0 && orangeTreeX - Math.abs(orangeX[i]) >= houseLeft && orangeTreeX - Math.abs(orangeX[i]) <= houseRight)
                .count());
    }
}
