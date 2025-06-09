package Bodlogo05;

import java.util.*;

public class QueensAttack {
    public static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int count = 0;

        int[][] directions = {
            {-1, 0}, 
            {1, 0},   
            {0, -1},  
            {0, 1},   
            {-1, -1}, 
            {-1, 1}, 
            {1, -1},  
            {1, 1}    
        };

        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "-" + obs[1]);
        }

        for (int[] dir : directions) {
            int row = r_q + dir[0];
            int col = c_q + dir[1];

            while (row >= 1 && row <= n && col >= 1 && col <= n) {
                if (obstacleSet.contains(row + "-" + col)) {
                    break;
                }
                count++;
                row += dir[0];
                col += dir[1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); 
        int k = scanner.nextInt(); 
        int r_q = scanner.nextInt(); 
        int c_q = scanner.nextInt(); 

        int[][] obstacles = new int[k][2];
        for (int i = 0; i < k; i++) {
            obstacles[i][0] = scanner.nextInt();
            obstacles[i][1] = scanner.nextInt();
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(result);
        scanner.close();
    }
}
