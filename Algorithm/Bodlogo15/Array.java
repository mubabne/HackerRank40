package Bodlogo15;
import java.util.*;

public class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = Integer.parseInt(scanner.nextLine());

        while (q-- > 0) {
            int n = Integer.parseInt(scanner.nextLine());
            int[] arr = new int[n];
            String[] input = scanner.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            System.out.println(isSortable(arr) ? "YES" : "NO");
        }
        scanner.close();
    }

    public static boolean isSortable(int[] arr) {
        int inversions = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) inversions++;
            }
        }
        return inversions % 2 == 0;
    }
}

