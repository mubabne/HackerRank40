package Bodlogo06;

import java.util.*;

public class OrganizingContainer {
    
    public static String organizingContainers(List<List<Integer>> container) {
        int n = container.size();
        int[] containerCapacity = new int[n];
        int[] typeCount = new int[n];

        for (int i = 0; i < n; i++) {
            List<Integer> row = container.get(i);
            for (int j = 0; j < n; j++) {
                containerCapacity[i] += row.get(j);
                typeCount[j] += row.get(j);
            }
        }

        Arrays.sort(containerCapacity);
        Arrays.sort(typeCount);

        return Arrays.equals(containerCapacity, typeCount) ? "Possible" : "Impossible";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        for (int t = 0; t < q; t++) {
            int n = scanner.nextInt();
            List<List<Integer>> container = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(scanner.nextInt());
                }
                container.add(row);
            }

            String result = organizingContainers(container);
            System.out.println(result);
        }
        scanner.close();   
    }
}


