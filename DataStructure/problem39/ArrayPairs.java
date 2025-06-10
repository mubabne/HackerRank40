package data_structure.problem39;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static long solve(List<Integer> arr) {
        int n = arr.size();
        long count = 0;

        for (int i = 0; i < n; i++) {
            int max = arr.get(i);
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, arr.get(j));
                long product = (long) arr.get(i) * arr.get(j);
                if (product <= max) {
                    count++;
                }
            }
        }

        return count;
    }

}

public class ArrayPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        long result = Result.solve(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
