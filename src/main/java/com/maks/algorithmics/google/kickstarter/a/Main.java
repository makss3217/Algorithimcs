import java.util.*;
import java.io.*;
public class Main {

    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for(int i = 1; i <= t; i++) {
            System.out.println("Case #" + i + ": " + testCase());
        }

    }

    private static Object testCase() {
        return 1;
    }
}
