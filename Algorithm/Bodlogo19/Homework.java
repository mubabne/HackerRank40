package Bodlogo19;

import java.util.*;

public class Homework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(Math.min(minSwaps(arr, true), minSwaps(arr, false)));
        scanner.close();
    }

    static int minSwaps(int[] arr, boolean ascending) {
        int n = arr.length;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        if (!ascending) {
            for (int i = 0; i < n / 2; i++) {
                int temp = sorted[i];
                sorted[i] = sorted[n - 1 - i];
                sorted[n - 1 - i] = temp;
            }
        }

        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        int swaps = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i] == sorted[i]) continue;

            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = indexMap.get(sorted[j]);
                cycleSize++;
            }
            if (cycleSize > 0) {
                swaps += cycleSize - 1;
            }
        }

        return swaps;
    }
}

