class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 0;
        
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }
        
        long k = (long) k1 + k2;
        
        int[] count = new int[maxDiff + 1];
        for (int i = 0; i < n; i++) {
            count[diff[i]]++;
        }
        
        // Seedha normal loop pointer i
        for (int i = maxDiff; i > 0 && k > 0; i--) {
            if (count[i] == 0) continue;
            
            if (k >= count[i]) {
                k -= count[i];
                count[i - 1] += count[i];
                count[i] = 0;
            } else {
                count[i - 1] += (int) k;
                count[i] -= (int) k;
                k = 0;
            }
        }
        
        long ans = 0;
        for (int i = 1; i <= maxDiff; i++) {
            if (count[i] > 0) {
                ans += (long) count[i] * (long) i * i;
            }
        }
        
        return ans;
    }
}