package algorithms.warmup;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author rong.li@mobilexag.de
 */
public class CircularArrayRotation {
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner sc = new Scanner(System.in);
//        final Scanner sc = new Scanner(Paths.get(System.getProperty("user.dir"), "/src/main/resources/input1.txt").toFile());

        int[] input = new int[] {0,0,0};
        IntStream.range(0, input.length).forEach(i -> input[i] = sc.nextInt());

        final int[] array = new int[input[0]];
        IntStream.range(0, array.length).forEach(i -> {
            array[i] = sc.nextInt();
        });

        int[] positions = new int[input[2]];
        IntStream.range(0, positions.length).forEach(i -> positions[i] = sc.nextInt());

        int rotationTimes = input[1] % array.length;
        if (rotationTimes == 0) {
            IntStream.range(0, positions.length).forEach(idx -> {
                System.out.println(array[positions[idx]]);
            });
        } else {
            int[] newArray = new int[array.length];
            IntStream.range(array.length - rotationTimes, array.length).forEach(i -> newArray[i - (array.length - rotationTimes)] = array[i]);
            IntStream.range(0, array.length - rotationTimes).forEach(i -> newArray[i + rotationTimes] = array[i]);
            IntStream.range(0, positions.length).forEach(idx -> System.out.println(newArray[positions[idx]]));
        }
    }
}
