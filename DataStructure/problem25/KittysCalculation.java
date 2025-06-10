package data_structure.problem25;

import java.io.*;
import java.util.*;

public class KittysCalculation {
    static final int MOD = 1_000_000_007;
    static int LOG = 20; // Increased for better coverage
    static List<Integer>[] tree;
    static int[][] up;
    static int[] depth, tin, tout;
    static int timer = 0;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int q = Integer.parseInt(first[1]);

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            tree[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            tree[a].add(b);
            tree[b].add(a);
        }

        up = new int[n + 1][LOG];
        depth = new int[n + 1];
        tin = new int[n + 1];
        tout = new int[n + 1];

        dfs(1, 1);
        preprocess(n);

        for (int qi = 0; qi < q; qi++) {
            int k = Integer.parseInt(br.readLine());
            int[] nodes = new int[k];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                nodes[i] = Integer.parseInt(st.nextToken());
            }

            long total = 0;
            Map<Long, Integer> lcaCache = new HashMap<>();

            // Optimize: precompute some values to avoid redundant calculations
            for (int i = 0; i < k; i++) {
                int u = nodes[i];
                for (int j = i + 1; j < k; j++) {
                    int v = nodes[j];
                    
                    // Create a unique key for the pair (u,v)
                    long pairKey = ((long) Math.min(u, v) << 32) | Math.max(u, v);
                    int lca_uv = lcaCache.computeIfAbsent(pairKey, key -> lca(u, v));
                    
                    int d = depth[u] + depth[v] - 2 * depth[lca_uv];
                    
                    // Optimize modular arithmetic
                    long uv = ((long) u * v) % MOD;
                    long term = (uv * d) % MOD;
                    total = (total + term) % MOD;
                }
            }

            System.out.println(total);
        }
    }

    static void dfs(int v, int p) {
        tin[v] = ++timer;
        up[v][0] = p;
        depth[v] = (p == v) ? 0 : depth[p] + 1;
        
        for (int to : tree[v]) {
            if (to != p) {
                dfs(to, v);
            }
        }
        tout[v] = ++timer;
    }
    
    static void preprocess(int n) {
        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                if (up[i][j - 1] != 0) {
                    up[i][j] = up[up[i][j - 1]][j - 1];
                }
            }
        }
    }

    static boolean isAncestor(int u, int v) {
        return tin[u] <= tin[v] && tout[v] <= tout[u];
    }

    static int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        
        // Bring u to the same level as v
        int diff = depth[u] - depth[v];
        for (int i = 0; i < LOG; i++) {
            if ((diff & (1 << i)) != 0) {
                u = up[u][i];
            }
        }
        
        if (u == v) return u;
        
        // Binary search for LCA
        for (int i = LOG - 1; i >= 0; i--) {
            if (up[u][i] != up[v][i]) {
                u = up[u][i];
                v = up[v][i];
            }
        }
        
        return up[u][0];
    }
}
