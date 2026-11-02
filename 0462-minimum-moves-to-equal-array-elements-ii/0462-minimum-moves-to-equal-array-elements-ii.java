class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        int moves = 0;

        int mid = n/2;
        int target = nums[mid];

        for(int x : nums){
            int current = Math.abs(x - target);
            moves = moves + current;

        }
        return moves;
    }
}