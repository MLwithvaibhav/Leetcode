class Solution {
    public int minCostClimbingStairs(int[] cost) { //
        int n = cost.length;
        
        // Hum index 0 ya index 1 se start kar sakte hain, isliye wahan tak aane ka starting cost 0 maanenge.
        int prev2 = 0; // Minimum cost to reach step 0
        int prev1 = 0; // Minimum cost to reach step 1
        
        // Humein top tak jana hai, jo array ke last index ke ek step baad (index n) hai.
        for (int i = 2; i <= n; i++) {
            // Step 'i' par pahunchne ke do raaste hain:
            // 1. (i-1) tak aane ka minimum cost + (i-1) par step karne ki cost
            // 2. (i-2) tak aane ka minimum cost + (i-2) par step karne ki cost
            int currentCost = Math.min(prev1 + cost[i - 1], prev2 + cost[i - 2]);
            
            // Variables ko aage shift karo next step ke liye
            prev2 = prev1;
            prev1 = currentCost;
        }
        
        // Loop ke baad prev1 mein top tak pahunchne ka final minimum cost hoga
        return prev1;
    }
}