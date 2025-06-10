package data_structure.problem34;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. STRING_ARRAY grid
     * 2. INTEGER startX
     * 3. INTEGER startY
     * 4. INTEGER goalX
     * 5. INTEGER goalY
     */

    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {
        int n = grid.size();
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { startX, startY, 0 }); // x, y, moves
        visited[startX][startY] = true;

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }; // down, up, right, left

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int moves = current[2];

            if (x == goalX && y == goalY)
                return moves;

            for (int[] dir : directions) {
                int dx = dir[0];
                int dy = dir[1];
                int nx = x + dx;
                int ny = y + dy;

                while (nx >= 0 && nx < n && ny >= 0 && ny < n && grid.get(nx).charAt(ny) != 'X') {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[] { nx, ny, moves + 1 });
                    }
                    nx += dx;
                    ny += dy;
                }
            }
        }

        return -1; // unreachable
    }

}

public class CastleOnTheGrid {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int startX = Integer.parseInt(firstMultipleInput[0]);

        int startY = Integer.parseInt(firstMultipleInput[1]);

        int goalX = Integer.parseInt(firstMultipleInput[2]);

        int goalY = Integer.parseInt(firstMultipleInput[3]);

        int result = Result.minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
