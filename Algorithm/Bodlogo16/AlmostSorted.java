package Bodlogo16;
import java.util.*;

public class AlmostSorted {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int l = -1, r = -1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                l = i;
                break;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                r = i;
                break;
            }
        }

        swap(arr, l, r);
        if (isSorted(arr)) {
            System.out.println("yes");
            System.out.println("swap " + (l + 1) + " " + (r + 1));
            return;
            
        }

        swap(arr, l, r); 
        reverse(arr, l, r);
        if (isSorted(arr)) {
            System.out.println("yes");
            System.out.println("reverse " + (l + 1) + " " + (r + 1));
        } else {
            System.out.println("no");
        }
        scanner.close();
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }
}
