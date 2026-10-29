import java.util.*;

class Solution {
    private List<Integer>[] adj;
    private int[] tin, tout, depth;
    private int[][] up;
    private int timer = 0;
    private int LOG;
    private int[] bit; // Binary Indexed Tree for prefix XORs
    private char[] val;

    private void add(int i, int delta) {
        for (; i < bit.length; i += i & -i) {
            bit[i] ^= delta;
        }
    }

    // Range XOR update [l, r]
    private void rangeUpdate(int l, int r, int delta) {
        add(l, delta);
        add(r + 1, delta);
    }

    // Point XOR query at index i
    private int pointQuery(int i) {
        int sum = 0;
        for (; i > 0; i -= i & -i) {
            sum ^= bit[i];
        }
        return sum;
    }

    private void dfs(int u, int p, int d) {
        tin[u] = ++timer;
        depth[u] = d;
        up[u][0] = p;
        for (int i = 1; i < LOG; i++) {
            up[u][i] = up[up[u][i - 1]][i - 1];
        }

        for (int v : adj[u]) {
            if (v != p) {
                dfs(v, u, d + 1);
            }
        }
        tout[u] = timer;
    }

    private int getLca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u; u = v; v = temp;
        }
        for (int i = LOG - 1; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                u = up[u][i];
            }
        }
        if (u == v) return u;
        for (int i = LOG - 1; i >= 0; i--) {
            if (up[u][i] != up[v][i]) {
                u = up[u][i];
                v = up[v][i];
            }
        }
        return up[u][0];
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        LOG = 1;
        while ((1 << LOG) <= n) LOG++;
        
        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        up = new int[n][LOG];
        val = s.toCharArray();
        timer = 0;

        dfs(0, 0, 0);

        bit = new int[timer + 2];

        // Initialize tree values
        for (int i = 0; i < n; i++) {
            int mask = 1 << (val[i] - 'a');
            rangeUpdate(tin[i], tout[i], mask);
        }

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char newC = parts[2].charAt(0);
                if (val[u] != newC) {
                    int delta = (1 << (val[u] - 'a')) ^ (1 << (newC - 'a'));
                    val[u] = newC;
                    rangeUpdate(tin[u], tout[u], delta);
                }
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int lca = getLca(u, v);

                int maskU = pointQuery(tin[u]);
                int maskV = pointQuery(tin[v]);
                int maskLca = pointQuery(tin[lca]);
                int lcaValMask = 1 << (val[lca] - 'a');

                // Path XOR: (root to u) ^ (root to v) ^ val[lca]
                // Since maskU ^ maskV removes the LCA bit twice, we add val[lca] back:
                int pathMask = maskU ^ maskV ^ lcaValMask;

                ans.add(Integer.bitCount(pathMask) <= 1);
            }
        }

        return ans;
    }
}