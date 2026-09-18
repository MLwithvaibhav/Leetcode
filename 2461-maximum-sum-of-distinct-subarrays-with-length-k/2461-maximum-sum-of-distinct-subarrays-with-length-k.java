class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long currentSum = 0;
        HashSet<Integer> set = new HashSet<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            // Step 1: Agar naya number set me pehle se hai, duplicate ko hatao
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            // Step 2: Naye number ko window me add karo
            set.add(nums[right]);
            currentSum += nums[right];

            // Step 3: Agar window ki length theek k ban gayi
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);

                // Agli window ke liye leftmost element hatao
                set.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }
}