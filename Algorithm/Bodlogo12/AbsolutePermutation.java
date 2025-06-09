package Bodlogo12;
import java.util.*;

public class AbsolutePermutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            if (k == 0) {
                for (int i = 1; i <= n; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
                continue;
            }

            if (n % (2 * k) != 0) {
                System.out.println("-1");
                continue;
            }

            boolean add = true;
            for (int i = 1; i <= n; i++) {
                if (add) {
                    System.out.print((i + k) + " ");
                } else {
                    System.out.print((i - k) + " ");
                }

                if (i % k == 0) {
                    add = !add;
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}
