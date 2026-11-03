class Solution {
    public int minMoves(int[] nums) {
        int max = 0;
        int moves = 0;

        for(int x : nums){
            if(x > max){
                max = x;
            }
        }

        for(int x : nums){
            int ans = max - x;
            moves = moves + ans;
        }
        return moves;
    }
}