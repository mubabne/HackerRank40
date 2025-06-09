package Bodlogo11;
import java.util.*;

public class SurfaceArea3D {
    


    public static int surfaceArea(List<List<Integer>> A) {
        int h = A.size();
        int w = A.get(0).size();
        int area = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int current = A.get(i).get(j);
                if (current > 0) area += 2;

                int up = i == 0 ? 0 : A.get(i - 1).get(j);
                int down = i == h - 1 ? 0 : A.get(i + 1).get(j);
                int left = j == 0 ? 0 : A.get(i).get(j - 1);
                int right = j == w - 1 ? 0 : A.get(i).get(j + 1);

                area += Math.max(current - up, 0);
                area += Math.max(current - down, 0);
                area += Math.max(current - left, 0);
                area += Math.max(current - right, 0);
            }
        }

        return area;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();

        List<List<Integer>> A = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < W; j++) {
                row.add(scanner.nextInt());
            }
            A.add(row);
        }

        int result = surfaceArea(A);
        System.out.println(result);
        scanner.close();
    }
}


