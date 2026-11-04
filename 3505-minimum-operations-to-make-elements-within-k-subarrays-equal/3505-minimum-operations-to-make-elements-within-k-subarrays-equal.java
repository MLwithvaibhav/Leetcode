import java.util.*;

class Solution {

    class MultiSet {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int size = 0;
        long sum = 0;

        void add(int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            size++;
            sum += val;
        }

        void remove(int val) {
            int count = map.get(val);

            if (count == 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }

            size--;
            sum -= val;
        }

        int getMin() {
            return map.firstKey();
        }

        int getMax() {
            return map.lastKey();
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        MultiSet left = new MultiSet();
        MultiSet right = new MultiSet();

        long[] cost = new long[n - x + 1];

        // Step 1: Calculate cost of every sliding window

        for (int i = 0; i < n; i++) {

            int val = nums[i];

            if (left.size == 0 || val <= left.getMax()) {
                left.add(val);
            } else {
                right.add(val);
            }

            if (i >= x) {
                int remove = nums[i - x];

                if (left.map.containsKey(remove)) {
                    left.remove(remove);
                } else {
                    right.remove(remove);
                }
            }

            // Balance both sets
            int target = (left.size + right.size + 1) / 2;

            while (left.size > target) {
                int v = left.getMax();
                left.remove(v);
                right.add(v);
            }

            while (left.size < target) {
                int v = right.getMin();
                right.remove(v);
                left.add(v);
            }

            // Calculate window cost
            if (i >= x - 1) {

                long median = left.getMax();

                long operations =
                    median * left.size - left.sum
                    + right.sum - median * right.size;

                cost[i - x + 1] = operations;
            }
        }

        // Step 2: Dynamic Programming

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= k; j++) {

                // Option 1: Skip current element
                dp[i][j] = dp[i - 1][j];

                // Option 2: Select a window of size x
                if (i >= x) {

                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - x][j - 1] + cost[i - x]
                    );
                }
            }
        }

        return dp[n][k];
    }
}