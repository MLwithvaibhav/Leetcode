class Solution {
    private static final int MOD = 1_000_000_007;

    // Segment Tree Node: sum of values, sum of squares, aur lazy tag
    static class Node {
        long sum = 0;
        long sqSum = 0;
        long lazy = 0;
    }

    private Node[] tree;

    private void apply(int node, int l, int r, long val) {
        long len = r - l + 1;
        val %= MOD;
        // (x + val)^2 = x^2 + 2 * val * x + val^2 * len
        tree[node].sqSum = (tree[node].sqSum + 2 * val % MOD * tree[node].sum % MOD + val * val % MOD * len % MOD) % MOD;
        tree[node].sum = (tree[node].sum + val * len % MOD) % MOD;
        tree[node].lazy = (tree[node].lazy + val) % MOD;
    }

    private void pushDown(int node, int l, int r) {
        if (tree[node].lazy != 0) {
            int mid = l + (r - l) / 2;
            apply(2 * node, l, mid, tree[node].lazy);
            apply(2 * node + 1, mid + 1, r, tree[node].lazy);
            tree[node].lazy = 0;
        }
    }

    private void pushUp(int node) {
        tree[node].sum = (tree[2 * node].sum + tree[2 * node + 1].sum) % MOD;
        tree[node].sqSum = (tree[2 * node].sqSum + tree[2 * node + 1].sqSum) % MOD;
    }

    private void update(int node, int l, int r, int ql, int qr, int val) {
        if (ql <= l && r <= qr) {
            apply(node, l, r, val);
            return;
        }
        pushDown(node, l, r);
        int mid = l + (r - l) / 2;
        if (ql <= mid) update(2 * node, l, mid, ql, qr, val);
        if (qr > mid) update(2 * node + 1, mid + 1, r, ql, qr, val);
        pushUp(node);
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        tree = new Node[4 * n];
        for (int i = 0; i < 4 * n; i++) {
            tree[i] = new Node();
        }

        Map<Integer, Integer> lastPos = new HashMap<>();
        long totalAns = 0;

        for (int i = 0; i < n; i++) {
            int prev = lastPos.getOrDefault(nums[i], -1);
            // nums[i] pehli baar aaya hai range (prev + 1) se i tak ke starting points ke liye
            update(1, 0, n - 1, prev + 1, i, 1);
            lastPos.put(nums[i], i);
            
            // Tree ka root (node 1) pure processed range ka sum of squares hold karta hai
            totalAns = (totalAns + tree[1].sqSum) % MOD;
        }

        return (int) totalAns;
    }
}