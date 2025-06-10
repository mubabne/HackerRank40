package data_structure.problem38;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count = 0;
    }

    public static List<Integer> contacts(List<List<String>> queries) {
        List<Integer> result = new ArrayList<>();
        TrieNode root = new TrieNode();

        for (List<String> query : queries) {
            String op = query.get(0);
            String val = query.get(1);

            if (op.equals("add")) {
                insert(root, val);
            } else if (op.equals("find")) {
                result.add(searchPrefixCount(root, val));
            }
        }

        return result;
    }

    private static void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
            node.count++;
        }
    }

    private static int searchPrefixCount(TrieNode root, String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children.get(c);
            if (node == null)
                return 0;
        }
        return node.count;
    }
}

public class Contacts {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> queries = new ArrayList<>();

        IntStream.range(0, queriesRows).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.contacts(queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
