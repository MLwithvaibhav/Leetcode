class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCount = new int[31];
        
        // Count the frequency of each bit
        for (int num : nums) {
            for (int b = 0; b <= 30; b++) {
                if (((num >> b) & 1) == 1) {
                    bitCount[b]++;
                }
            }
        }
        
        long totalSum = 0;
        long MOD = 1_000_000_007L;
        
        // Form the k largest numbers
        for (int i = 0; i < k; i++) {
            long currentVal = 0;
            for (int b = 0; b <= 30; b++) {
                if (bitCount[b] > 0) {
                    currentVal |= (1L << b);
                    bitCount[b]--;
                }
            }
            totalSum = (totalSum + (currentVal * currentVal) % MOD) % MOD;
        }
        
        return (int) totalSum;
    }
}