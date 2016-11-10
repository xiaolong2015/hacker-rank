package algorithms;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author rong.li@mobilexag.de
 */
public class AngryProfessor {
    public static void main(String[] args) throws FileNotFoundException {
//        final Scanner sc = new Scanner(Paths.get(System.getProperty("user.dir"), "/src/main/resources/angry-professor.txt").toFile());

        final Scanner sc = new Scanner(System.in);

        int testCaseNumber = sc.nextInt();
        // [testcase][0][student number]
        // [testcase][0][threshold]
        // [testcase][1][arrive times]
        int[][][] arrays = new int[testCaseNumber][2][1000];
        IntStream.range(0, testCaseNumber)
            .forEach(i -> {
                arrays[i][0][0] = sc.nextInt();
                arrays[i][0][1] = sc.nextInt();
                IntStream.range(0, arrays[i][0][0]).forEach(j -> arrays[i][1][j] = sc.nextInt());
            });
        IntStream.range(0, testCaseNumber)
            .forEach(i -> {
                long attendanceStudents = IntStream.range(0, arrays[i][0][0]).filter(j -> arrays[i][1][j] <= 0).count();
                if (attendanceStudents >= arrays[i][0][1])
                    System.out.println("NO");
                else
                    System.out.println("YES");
            });
    }
}
