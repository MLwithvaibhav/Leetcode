class Solution {
    public int longestSubarray(int[] nums, int k) {

        int n = nums.length;
        int ans = 0;

        for(int left = 0; left<n; left++){
            long sum = 0;
            boolean[] rem = new boolean[k];

            for(int right = left; right<n; right++){
                sum += nums[right];
                int val = (((2*nums[right])%k) + k) %k;
                rem[val] = true;

                int sumRem = (int)((sum%k)+k)%k;

                if(sumRem == 0 || rem[sumRem]){
                    ans = Math.max(ans, right-left+1);
                }
                
            }
        }
        return ans;
        
    }
}