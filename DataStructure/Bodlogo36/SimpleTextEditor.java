package Bodlogo36;

import java.io.*;
import java.util.*;

public class SimpleTextEditor {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(reader.readLine());

        StringBuilder current = new StringBuilder();
        Deque<String> history = new ArrayDeque<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            String[] parts = reader.readLine().split(" ", 2);
            int type = Integer.parseInt(parts[0]);

            switch (type) {
                case 1: 
                    history.push(current.toString());
                    current.append(parts[1]);
                    break;

                case 2: 
                    history.push(current.toString());
                    int k = Integer.parseInt(parts[1]);
                    current.setLength(current.length() - k);
                    break;

                case 3: 
                    int pos = Integer.parseInt(parts[1]);
                    output.append(current.charAt(pos - 1)).append("\n");
                    break;

                case 4: 
                    if (!history.isEmpty()) {
                        current = new StringBuilder(history.pop());
                    }
                    break;
            }
        }

        System.out.print(output);
    }
}
