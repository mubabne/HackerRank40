package Bodlogo07;
import java.util.*;

public class Encryption {
    

    public static String encryption(String s) {
        s = s.replaceAll("\\s", "");
        int L = s.length();
        int rows = (int) Math.floor(Math.sqrt(L));
        int cols = (int) Math.ceil(Math.sqrt(L));
        if (rows * cols < L) rows++;

        StringBuilder result = new StringBuilder();

        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                int idx = r * cols + c;
                if (idx < L) result.append(s.charAt(idx));
            }
            result.append(' ');
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String result = encryption(s);
        System.out.println(result);
        scanner.close();
    }
}

