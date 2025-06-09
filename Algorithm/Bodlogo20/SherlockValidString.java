package Bodlogo20;
import java.util.*;

public class SherlockValidString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        Map<Integer, Integer> freqCount = new HashMap<Integer, Integer>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                int count = freq[i];
                if (!freqCount.containsKey(count)) {
                    freqCount.put(count, 1);
                } else {
                    freqCount.put(count, freqCount.get(count) + 1);
                }
            }
        }

        if (freqCount.size() == 1) {
            System.out.println("YES");
        } else if (freqCount.size() == 2) {
            Iterator<Integer> it = freqCount.keySet().iterator();
            int a = it.next();
            int b = it.next();

            int freqA = freqCount.get(a);
            int freqB = freqCount.get(b);

            if ((a == 1 && freqA == 1) || (b == 1 && freqB == 1)) {
                System.out.println("YES");
            } else if ((Math.abs(a - b) == 1) && (freqA == 1 || freqB == 1)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            System.out.println("NO");
        }
    }
}

