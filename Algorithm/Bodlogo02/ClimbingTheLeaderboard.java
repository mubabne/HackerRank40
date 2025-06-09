package Bodlogo02;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ClimbingTheLeaderboard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> uniqueRanks = new ArrayList<>();
        int lastScore = -1;

        for (int score : ranked) {
            if (score != lastScore) {
                uniqueRanks.add(score);
                lastScore = score;
            }
        }

        List<Integer> result = new ArrayList<>();
        int i = uniqueRanks.size() - 1;

        for (int score : player) {
            while (i >= 0 && score >= uniqueRanks.get(i)) {
                i--;
            }
            result.add(i + 2); 
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> ranked = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ranked.add(scanner.nextInt());
        }

        int m = scanner.nextInt();
        List<Integer> player = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            player.add(scanner.nextInt());
        }

        List<Integer> result = climbingLeaderboard(ranked, player);
        for (int rank : result) {
            System.out.println(rank);
        }
        scanner.close();
    }
}


