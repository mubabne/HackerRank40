package data_structure.problem24;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        Node root = buildTree(indexes);
        List<List<Integer>> result = new ArrayList<>();

        for (int k : queries) {
            swapAtDepth(root, 1, k);
            List<Integer> traversal = new ArrayList<>();
            inOrderTraversal(root, traversal);
            result.add(traversal);
        }

        return result;
    }

    private static Node buildTree(List<List<Integer>> indexes) {
        Node root = new Node(1);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 0;

        while (!queue.isEmpty() && i < indexes.size()) {
            Node current = queue.poll();
            int left = indexes.get(i).get(0);
            int right = indexes.get(i).get(1);

            if (left != -1) {
                current.left = new Node(left);
                queue.add(current.left);
            }
            if (right != -1) {
                current.right = new Node(right);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    private static void swapAtDepth(Node node, int depth, int k) {
        if (node == null)
            return;

        if (depth % k == 0) {
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }

        swapAtDepth(node.left, depth + 1, k);
        swapAtDepth(node.right, depth + 1, k);
    }

    private static void inOrderTraversal(Node node, List<Integer> traversal) {
        if (node == null)
            return;
        inOrderTraversal(node.left, traversal);
        traversal.add(node.data);
        inOrderTraversal(node.right, traversal);
    }
}

public class SwapNodes {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                indexes.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<List<Integer>> result = Result.swapNodes(indexes, queries);

        result.stream()
                .map(
                        r -> r.stream()
                                .map(Object::toString)
                                .collect(joining(" ")))
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
