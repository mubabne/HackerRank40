package Bodlogo10;
import java.util.*;
public class TheGridSearch {

    public static String gridSearch(List<String> G, List<String> P) {
        int R = G.size();
        int C = G.get(0).length();
        int r = P.size();
        int c = P.get(0).length();

        for (int i = 0; i <= R - r; i++) {
            for (int j = 0; j <= C - c; j++) {
                boolean match = true;
                for (int x = 0; x < r; x++) {
                    if (!G.get(i + x).substring(j, j + c).equals(P.get(x))) {
                        match = false;
                        break;
                    }
                }
                if (match) return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < T; t++) {
            String[] dimsG = scanner.nextLine().split(" ");
            int R = Integer.parseInt(dimsG[0]);

            List<String> G = new ArrayList<>();
            for (int i = 0; i < R; i++) {
                G.add(scanner.nextLine());
            }

            String[] dimsP = scanner.nextLine().split(" ");
            int r = Integer.parseInt(dimsP[0]);

            List<String> P = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                P.add(scanner.nextLine());
            }

            String result = gridSearch(G, P);
            System.out.println(result);
        }
        scanner.close();
    }
}


