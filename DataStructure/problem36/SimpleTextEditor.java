package data_structure.problem36;

import java.io.*;
import java.util.*;

public class SimpleTextEditor {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(reader.readLine());

        StringBuilder current = new StringBuilder();
        Deque<String> history = new ArrayDeque<>(); // To support undo
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            String[] parts = reader.readLine().split(" ", 2);
            int type = Integer.parseInt(parts[0]);

            switch (type) {
                case 1: // append(W)
                    history.push(current.toString());
                    current.append(parts[1]);
                    break;

                case 2: // delete(k)
                    history.push(current.toString());
                    int k = Integer.parseInt(parts[1]);
                    current.setLength(current.length() - k);
                    break;

                case 3: // print(k)
                    int pos = Integer.parseInt(parts[1]);
                    output.append(current.charAt(pos - 1)).append("\n");
                    break;

                case 4: // undo()
                    if (!history.isEmpty()) {
                        current = new StringBuilder(history.pop());
                    }
                    break;
            }
        }

        System.out.print(output);
    }
}
