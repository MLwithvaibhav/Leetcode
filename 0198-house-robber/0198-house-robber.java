class Solution {
    public int rob(int[] nums) { //
        // Agar array khali hai, toh koi paisa nahi milega
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // Pichle do houses tak ka maximum profit track karne ke liye variables
        int prev2 = 0; // i-2 tak ka max profit
        int prev1 = 0; // i-1 tak ka max profit
        
        // Har ek house par loop lagayenge
        for (int i = 0; i < nums.length; i++) {
            // Har house par humare paas 2 choices hain:
            // 1. Current house ko rob karo: Toh humein us current house ka paisa (nums[i]) 
            //    plus (i-2) tak ka max profit (prev2) milega.
            // 2. Current house ko skip karo: Toh humein pichle house tak ka max profit (prev1) hi milega.
            
            // Dono choices mein se jo maximum hoga, wo current max ban jayega.
            int currentMax = Math.max(prev1, prev2 + nums[i]);
            
            // Next iteration ke liye variables ko aage shift kar do
            prev2 = prev1;
            prev1 = currentMax;
        }
        
        // Loop khatam hone ke baad prev1 mein total maximum robbed amount hoga
        return prev1;
    }
}