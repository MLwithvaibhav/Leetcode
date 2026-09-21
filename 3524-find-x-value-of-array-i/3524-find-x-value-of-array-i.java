class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] prev = new long[k];
        
        for (int x : nums) {
            long[] curr = new long[k];
            int val = x % k;
            
            // 1. Single element wala subarray [nums[i]]
            curr[val]++;
            
            // 2. Pichle subarrays ko extend karna
            for (int r = 0; r < k; r++) {
                if (prev[r] > 0) {
                    int newRem = (int)((1L * r * val) % k);
                    curr[newRem] += prev[r];
                }
            }
            
            // 3. Final answer update karna
            for (int r = 0; r < k; r++) {
                result[r] += curr[r];
            }
            
            prev = curr;
        }
        
        return result;
    }
}