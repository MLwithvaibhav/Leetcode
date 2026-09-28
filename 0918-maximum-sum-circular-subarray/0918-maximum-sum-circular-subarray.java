class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        
        int currMax = 0;
        int maxKadane = nums[0];
        
        int currMin = 0;
        int minKadane = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            
            // 1. Max Kadane logic
            currMax += nums[i];
            if (currMax > maxKadane) {
                maxKadane = currMax;
            }
            if (currMax < 0) {
                currMax = 0;
            }
            
            // 2. Min Kadane logic
            currMin += nums[i];
            if (currMin < minKadane) {
                minKadane = currMin;
            }
            if (currMin > 0) {
                currMin = 0;
            }
        }
        
        // Agar saare elements negative hain, toh circular wrap empty array dega
        if (maxKadane < 0) {
            return maxKadane;
        }
        
        return Math.max(maxKadane, totalSum - minKadane);
    }
}