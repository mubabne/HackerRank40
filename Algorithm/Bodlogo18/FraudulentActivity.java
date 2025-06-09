package Bodlogo18;

import java.util.*;

public class FraudulentActivity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[] expenditure = new int[n];
        for (int i = 0; i < n; i++) {
            expenditure[i] = scanner.nextInt();
        }

        int[] count = new int[201];
        for (int i = 0; i < d; i++) {
            count[expenditure[i]]++;
        }

        int notifications = 0;
        for (int i = d; i < n; i++) {
            double median = getMedian(count, d);
            if (expenditure[i] >= 2 * median) {
                notifications++;
            }

            count[expenditure[i - d]]--;
            count[expenditure[i]]++;
        }

        System.out.println(notifications);
        scanner.close();
    }

    static double getMedian(int[] count, int d) {
        int sum = 0;
        if (d % 2 == 1) {
            int mid = d / 2 + 1;
            for (int i = 0; i < count.length; i++) {
                sum += count[i];
                if (sum >= mid) return i;
            }
        } else {
            int mid1 = d / 2;
            int mid2 = mid1 + 1;
            int first = -1;
            int second = -1;
            for (int i = 0; i < count.length; i++) {
                sum += count[i];
                if (first == -1 && sum >= mid1) first = i;
                if (sum >= mid2) {
                    second = i;
                    break;
                }
            }
            return (first + second) / 2.0;
        }
        return 0.0;
    }
}

