class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int windowSize = n - k;
        int totalSum = 0;

        for (int j = 0; j < n; j++) {
            totalSum += cardPoints[j];
        }

        // Agar saare cards uthane hain
        if (k == n) {
            return totalSum;
        }

        int sum = 0;
        for (int i = 0; i < windowSize; i++) {
            sum += cardPoints[i];
        }

        // minSum ko pehli window ke sum se start karo
        int minSum = sum;

        for (int i = windowSize; i < n; i++) {
            sum += cardPoints[i];
            sum -= cardPoints[i - windowSize];
            
            // Yahan < check karna hai, > nahi!
            if (sum < minSum) {
                minSum = sum;
            }
        }

        return totalSum - minSum;
    }
}