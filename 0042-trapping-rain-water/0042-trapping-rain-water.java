class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int sum = 0;

        int[] leftArr = new int[n];
        int[] rightArr = new int[n];

        // Base values
        leftArr[0] = height[0];
        rightArr[n - 1] = height[n - 1];

        // 1. Left Max array fill karo
        for (int i = 1; i < n; i++) {
            leftArr[i] = Math.max(leftArr[i - 1], height[i]);
        }

        // 2. Right Max array fill karo (rightArr[i] par update karo)
        for (int i = n - 2; i >= 0; i--) {
            rightArr[i] = Math.max(rightArr[i + 1], height[i]);
        }

        // 3. Water trap calculate karo
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftArr[i], rightArr[i]);
            sum += waterLevel - height[i];
        }

        return sum;
    }
}