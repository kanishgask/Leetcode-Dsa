import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    static int LOG;
    static int[] depth;
    static int[][] up;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        LOG = 20; // since n <= 1e5, log2(n) < 20
        depth = new int[n + 1];
        up = new int[LOG][n + 1];

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        // DFS to fill depth and parent
        dfs(1, 0, adj);

        // Binary lifting table
        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                up[j][i] = up[j - 1][ up[j - 1][i] ];
            }
        }

        // Precompute powers of 2
        long[] pow2 = new long[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        // Answer queries
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0], v = queries[i][1];
            if (u == v) {
                ans[i] = 0;
                continue;
            }
            int lca = getLCA(u, v);
            int pathLen = depth[u] + depth[v] - 2 * depth[lca];
            ans[i] = (int) pow2[pathLen - 1]; // half of total assignments
        }
        return ans;
    }

    private void dfs(int u, int p, List<List<Integer>> adj) {
        up[0][u] = p;
        for (int v : adj.get(u)) {
            if (v == p) continue;
            depth[v] = depth[u] + 1;
            dfs(v, u, adj);
        }
    }

    private int getLCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int tmp = a; a = b; b = tmp;
        }
        // Lift a up
        for (int j = LOG - 1; j >= 0; j--) {
            if (depth[a] - (1 << j) >= depth[b]) {
                a = up[j][a];
            }
        }
        if (a == b) return a;
        for (int j = LOG - 1; j >= 0; j--) {
            if (up[j][a] != up[j][b]) {
                a = up[j][a];
                b = up[j][b];
            }
        }
        return up[0][a];
    }
}
