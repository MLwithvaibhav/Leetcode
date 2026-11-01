class Solution {
    public int minMoves(int[] nums) {
        int min =  nums[0];
        int moves = 0;
        for(int x : nums){
            if(x<min){
                min = x;
            }
        }

        for(int x : nums){
            int ans = x-min;
            moves = moves+ans;
        }
        return moves;
    }
}