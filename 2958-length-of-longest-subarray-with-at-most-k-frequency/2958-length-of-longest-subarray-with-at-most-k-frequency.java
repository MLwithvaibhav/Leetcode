import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            int currentNum = nums[right];
            
            // 1. Current element ki frequency map me badhao
            freqMap.put(currentNum, freqMap.getOrDefault(currentNum, 0) + 1);

            // 2. Agar current element ka count k se zyada ho gaya, 
            //    toh left se elements shrink karo jab tak count valid na ho jaye
            while (freqMap.get(currentNum) > k) {
                int leftNum = nums[left];
                freqMap.put(leftNum, freqMap.get(leftNum) - 1);
                left++;
            }

            // 3. Valid window ka size evaluate karke max update karo
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}