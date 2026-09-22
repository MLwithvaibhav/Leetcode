class Solution {
    static class Node {
        int[] count;
        int prod;

        Node(int k) {
            count = new int[k];
            prod = 1;
        }
    }

    private Node[] tree;
    private int[] arr;
    private int n, mod;

    private Node merge(Node left, Node right) {
        Node res = new Node(mod);
        res.prod = (int) (((long) left.prod * right.prod) % mod);

        // Left ke prefix counts directly carry forward honge
        for (int i = 0; i < mod; i++) {
            res.count[i] += left.count[i];
        }

        // Right ke prefix counts left ke total product se scale honge
        for (int i = 0; i < mod; i++) {
            int newRem = (int) (((long) i * left.prod) % mod);
            res.count[newRem] += right.count[i];
        }
        return res;
    }

    private void build(int node, int l, int r) {
        if (l == r) {
            tree[node] = new Node(mod);
            int val = arr[l] % mod;
            tree[node].prod = val;
            tree[node].count[val] = 1;
            return;
        }
        int mid = (l + r) / 2;
        build(2 * node, l, mid);
        build(2 * node + 1, mid + 1, r);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            arr[idx] = val;
            tree[node] = new Node(mod);
            int rem = val % mod;
            tree[node].prod = rem;
            tree[node].count[rem] = 1;
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid) {
            update(2 * node, l, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, r, idx, val);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    // Range [ql, qr] me queries ko evaluate karna
    private int query(int node, int l, int r, int ql, int qr, int[] runningProd, int targetX) {
        if (ql <= l && r <= qr) {
            int ans = 0;
            // Current tree[node] se kitne remainder target banate hain runningProd ke saath
            for (int rem = 0; rem < mod; rem++) {
                if ((rem * runningProd[0]) % mod == targetX) {
                    ans += tree[node].count[rem];
                }
            }
            runningProd[0] = (int) (((long) runningProd[0] * tree[node].prod) % mod);
            return ans;
        }

        int mid = (l + r) / 2;
        int ans = 0;
        if (ql <= mid) {
            ans += query(2 * node, l, mid, ql, qr, runningProd, targetX);
        }
        if (qr > mid) {
            ans += query(2 * node + 1, mid + 1, r, ql, qr, runningProd, targetX);
        }
        return ans;
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.arr = nums;
        this.n = nums.length;
        this.mod = k;
        this.tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int targetX = queries[i][3];

            // Point update
            update(1, 0, n - 1, idx, val);

            // Range query from start to n - 1
            int[] runningProd = new int[]{1};
            res[i] = query(1, 0, n - 1, start, n - 1, runningProd, targetX);
        }

        return res;
    }
}