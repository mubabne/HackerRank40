package Bodlogo17;

import java.util.*;

public class CountingSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<String>> buckets = new ArrayList<List<String>>();
        for (int i = 0; i < 100; i++) {
            buckets.add(new ArrayList<String>());
        }

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            String s = scanner.next();
            if (i < n / 2) {
                buckets.get(x).add("-");
            } else {
                buckets.get(x).add(s);
            }
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            List<String> list = buckets.get(i);
            for (int j = 0; j < list.size(); j++) {
                output.append(list.get(j)).append(" ");
            }
        }

        System.out.println(output.toString().trim());
        scanner.close();
    }
}
