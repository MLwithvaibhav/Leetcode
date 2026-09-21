import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            int currentNum = nums[right];

            // 1. Current element ka count badhao (Simple If-Else)
            if (!freqMap.containsKey(currentNum)) {
                // Pehli baar aaya hai toh count 1 set karo
                freqMap.put(currentNum, 1);
            } else {
                // Pehle se hai toh purana count nikaal ke 1 add karo
                int puranaCount = freqMap.get(currentNum);
                freqMap.put(currentNum, puranaCount + 1);
            }

            // 2. Agar current element ka count k se zyada ho gaya, left se shrink karo
            while (freqMap.get(currentNum) > k) {
                int leftNum = nums[left];
                int puranaLeftCount = freqMap.get(leftNum);
                
                // Left wale element ka count 1 se kam karo
                freqMap.put(leftNum, puranaLeftCount - 1);
                
                left++; // Window aage badhao
            }

            // 3. Current window size compare karke max update karo
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}