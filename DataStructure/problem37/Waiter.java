package data_structure.problem37;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'waiter' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY number
     * 2. INTEGER q
     */

    public static List<Integer> waiter(List<Integer> number, int q) {
        List<Integer> answers = new ArrayList<>();
        List<Integer> primes = generatePrimes(q);

        Deque<Integer> current = new ArrayDeque<>(number); // preserves insertion order
        Deque<Integer> next = new ArrayDeque<>();

        for (int i = 0; i < q; i++) {
            int prime = primes.get(i);
            Deque<Integer> bStack = new ArrayDeque<>();

            while (!current.isEmpty()) {
                int plate = current.pollLast(); // simulate stack: take from end
                if (plate % prime == 0) {
                    bStack.addLast(plate); // FIFO order
                } else {
                    next.addLast(plate);
                }
            }

            // Append B_i stack top to bottom (i.e., reverse of how added)
            while (!bStack.isEmpty()) {
                answers.add(bStack.pollLast());
            }

            // Prepare for next iteration
            Deque<Integer> temp = current;
            current = next;
            next = temp;
        }

        // Remaining elements in current (A_q), top to bottom
        while (!current.isEmpty()) {
            answers.add(current.pollLast()); // top-to-bottom
        }

        return answers;
    }

    private static List<Integer> generatePrimes(int limit) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[13000];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; primes.size() < limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = 2 * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return primes;
    }

}

public class Waiter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.waiter(number, q);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
