import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        
        // diary array: index i tak ka sabse chhota valid tukda (length)
        int[] diary = new int[n];
        Arrays.fill(diary, Integer.MAX_VALUE);

        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int bestSoFar = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            // Agar sum target se bada ho gaya, toh peeche se (left se) shrink karo
            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            // Agar sum target ke barabar mil gaya
            if (sum == target) {
                int currentLen = right - left + 1;

                // Non-overlapping check:
                // Kya is tukde ke shuru hone se pehle (left - 1 tak) koi aur tukda tha diary mein?
                if (left > 0 && diary[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, currentLen + diary[left - 1]);
                }

                // Ab tak ka sabse chhota tukda update karo
                bestSoFar = Math.min(bestSoFar, currentLen);
            }

            // Diary mein record karo ki right index tak sabse chhota tukda kaunsa mila
            diary[right] = bestSoFar;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}