import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    // Complete the numberOfPairs function below.
    static int numberOfPairs(int[] a, long k) {
        int count = 0;

        HashSet<Long> visited = new HashSet<Long>();
        HashSet<Long> distinct = new HashSet<Long>();

        for (int i = 0; i < a.length; i++) {
            long diff = k - a[i];

            if (visited.contains(diff)) {
                if (!distinct.contains((long)a[i]) && !distinct.contains(diff)) {
                    count++;
                    distinct.add((long)a[i]);
                    distinct.add(diff);
                }
            }

            visited.add((long)a[i]);
        }

        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[aCount];

        for (int i = 0; i < aCount; i++) {
            int aItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            a[i] = aItem;
        }

        long k = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int res = numberOfPairs(a, k);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
