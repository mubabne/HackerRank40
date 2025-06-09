package Bodlogo09;
import java.util.*;

public class TimeInWords {
    
    static String[] words = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
        "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three",
        "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine"
    };

    public static String timeInWords(int h, int m) {
        if (m == 0) return words[h] + " o' clock";
        if (m == 15) return "quarter past " + words[h];
        if (m == 30) return "half past " + words[h];
        if (m == 45) return "quarter to " + words[h + 1];
        if (m < 30) return words[m] + (m == 1 ? " minute past " : " minutes past ") + words[h];
        return words[60 - m] + (60 - m == 1 ? " minute to " : " minutes to ") + words[h + 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(timeInWords(h, m));
        scanner.close();
    }
}


