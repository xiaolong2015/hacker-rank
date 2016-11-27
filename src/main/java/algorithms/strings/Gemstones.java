package algorithms.strings;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Gemstones {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(
                Paths.get(System.getProperty("user.dir"), "/src/main/resources/gemstones.txt").toFile());
        int rockNumber = sc.nextInt();
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < rockNumber; i++) {
            String s = sc.next();
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < s.length(); j++) {
                set.add((int) s.charAt(j));
            }
            list.add(set);
        }
        Set<Integer> set = new HashSet<>(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            set.retainAll(list.get(i));
        }
        System.out.println(set.size());
    }
}
