class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int sum = 0;
        int targetSum = k * threshold;

        // Pehli window ka sum
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        if (sum >= targetSum) {
            count++;
        }

        // Sliding window aage badhao
        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];

            // Har step par window check loop ke andar hoga
            if (sum >= targetSum) {
                count++;
            }
        }

        return count;
    }
}