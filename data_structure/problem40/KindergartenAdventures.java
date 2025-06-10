package data_structure.problem40;

import java.io.*;
import java.util.*;

public class KindergartenAdventures {

    /*
     * Complete the solve function below.
     */
    static int solve(int[] t) {
        int n = t.length;
        int maxComplete = -1;
        int bestStart = 0;

        for (int x = 0; x < n; x++) {
            int count = 0;

            for (int i = 0; i < n; i++) {
                int studentId = (x + i) % n;
                if (t[studentId] <= i)
                    count++;
            }

            if (count > maxComplete) {
                maxComplete = count;
                bestStart = x;
            }
        }

        return bestStart + 1; // return as 1-based ID
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int tCount = Integer.parseInt(scanner.nextLine().trim());

        int[] t = new int[tCount];

        String[] tItems = scanner.nextLine().split(" ");

        for (int tItr = 0; tItr < tCount; tItr++) {
            int tItem = Integer.parseInt(tItems[tItr].trim());
            t[tItr] = tItem;
        }

        int id = solve(t);

        bufferedWriter.write(String.valueOf(id));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
