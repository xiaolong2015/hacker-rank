package algorithms.warmup;

import java.util.Scanner;

/**
 * @author rong.li@mobilexag.de
 */
public class TimeConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String timeStr = sc.next();
        if (timeStr.startsWith("12") && timeStr.endsWith("AM"))
            System.out.println("00" + timeStr.substring(2, timeStr.length() - 2));
        else if (timeStr.startsWith("12") && timeStr.endsWith("PM"))
            System.out.println(timeStr.substring(0, timeStr.length() - 2));
        else if (timeStr.endsWith("AM"))
            System.out.println(timeStr.substring(0, timeStr.length() - 2));
        else {
            int hour = (Integer.parseInt(timeStr.substring(0, 2)) + 12) % 24;
            System.out.format("%2d%s", hour, timeStr.substring(2, timeStr.length() - 2));
        }
    }
}
