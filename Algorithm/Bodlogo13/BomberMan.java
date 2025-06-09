package Bodlogo13;
import java.util.*;

public class BomberMan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstMultipleInput = scanner.nextLine().split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);
        int c = Integer.parseInt(firstMultipleInput[1]);
        int n = Integer.parseInt(firstMultipleInput[2]);

        String[] grid = new String[r];
        for (int i = 0; i < r; i++) {
            grid[i] = scanner.nextLine();
        }

        String[] result = bomberMan(n, grid);
        for (String row : result) {
            System.out.println(row);
        }
        scanner.close();
    }

    public static String[] bomberMan(int n, String[] grid) {
        if (n == 1) return grid;
        if (n % 2 == 0) {
            char[] fullRow = new char[grid[0].length()];
            Arrays.fill(fullRow, 'O');
            String full = new String(fullRow);
            String[] result = new String[grid.length];
            Arrays.fill(result, full);
            return result;
        }

        String[] firstDetonation = detonate(grid);
        String[] secondDetonation = detonate(firstDetonation);
        return (n % 4 == 3) ? firstDetonation : secondDetonation;
    }

    private static String[] detonate(String[] grid) {
        int r = grid.length;
        int c = grid[0].length();
        char[][] result = new char[r][c];

        for (int i = 0; i < r; i++) {
            Arrays.fill(result[i], 'O');
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i].charAt(j) == 'O') {
                    result[i][j] = '.';
                    if (i > 0) result[i - 1][j] = '.';
                    if (i < r - 1) result[i + 1][j] = '.';
                    if (j > 0) result[i][j - 1] = '.';
                    if (j < c - 1) result[i][j + 1] = '.';
                }
            }
        }

        String[] finalGrid = new String[r];
        for (int i = 0; i < r; i++) {
            finalGrid[i] = new String(result[i]);
        }
        return finalGrid;
    }
}
