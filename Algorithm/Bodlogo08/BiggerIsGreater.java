package Bodlogo08;
import java.util.*;

public class BiggerIsGreater {

    public static String biggerIsGreater(String w) {
        char[] chars = w.toCharArray();
        int i = chars.length - 2;

        while (i >= 0 && chars[i] >= chars[i + 1]) i--;

        if (i < 0) return "no answer";

        int j = chars.length - 1;
        while (chars[j] <= chars[i]) j--;

        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;

        Arrays.sort(chars, i + 1, chars.length);
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            String w = scanner.nextLine();
            System.out.println(biggerIsGreater(w));
        }
        scanner.close();
    }
}


