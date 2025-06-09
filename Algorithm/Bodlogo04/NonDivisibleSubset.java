package Bodlogo04;

import java.util.*;

public class NonDivisibleSubset {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] remainderCount = new int[k];

        for (int num : s) {
            remainderCount[num % k]++;
        }

        int count = 0;

        if (remainderCount[0] > 0) {
            count += 1;
        }

        for (int i = 1; i <= k / 2; i++) {
            if (i == k - i) {
                if (remainderCount[i] > 0) {
                    count += 1;
                }
            } else {
                count += Math.max(remainderCount[i], remainderCount[k - i]);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            s.add(scanner.nextInt());
        }

        int result = nonDivisibleSubset(k, s);
        System.out.println(result);
        scanner.close();
    }
}
