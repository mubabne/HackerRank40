package Bodlogo14;
import java.util.*;

public class DoublePlus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] first = scanner.nextLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = scanner.nextLine().toCharArray();
        }

        List<int[]> pluses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int size = 0;
                while (isValid(grid, i, j, size)) {
                    pluses.add(new int[]{i, j, size});
                    size++;
                }
            }
        }

        int maxProduct = 0;

        for (int i = 0; i < pluses.size(); i++) {
            for (int j = i + 1; j < pluses.size(); j++) {
                if (!overlap(pluses.get(i), pluses.get(j))) {
                    int area1 = 1 + pluses.get(i)[2] * 4;
                    int area2 = 1 + pluses.get(j)[2] * 4;
                    maxProduct = Math.max(maxProduct, area1 * area2);
                }
            }
        }
        scanner.close();
        System.out.println(maxProduct);
    }

    static boolean isValid(char[][] grid, int x, int y, int size) {
        int n = grid.length, m = grid[0].length;
        if (x - size < 0 || x + size >= n || y - size < 0 || y + size >= m) return false;
        for (int i = -size; i <= size; i++) {
            if (grid[x + i][y] != 'G' || grid[x][y + i] != 'G') return false;
        }
        return true;
    }

    static boolean overlap(int[] p1, int[] p2) {
        Set<String> s1 = new HashSet<>();
        s1.add(p1[0] + "," + p1[1]);
        for (int d = 1; d <= p1[2]; d++) {
            s1.add((p1[0] + d) + "," + p1[1]);
            s1.add((p1[0] - d) + "," + p1[1]);
            s1.add(p1[0] + "," + (p1[1] + d));
            s1.add(p1[0] + "," + (p1[1] - d));
        }

        if (s1.contains(p2[0] + "," + p2[1])) return true;
        for (int d = 1; d <= p2[2]; d++) {
            if (s1.contains((p2[0] + d) + "," + p2[1])) return true;
            if (s1.contains((p2[0] - d) + "," + p2[1])) return true;
            if (s1.contains(p2[0] + "," + (p2[1] + d))) return true;
            if (s1.contains(p2[0] + "," + (p2[1] - d))) return true;
        }

        return false;
    }
}
