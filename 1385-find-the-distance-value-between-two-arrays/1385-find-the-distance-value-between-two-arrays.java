import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;

        for (int val : arr1) {
            if (isValid(arr2, val, d)) {
                count++;
            }
        }

        return count;
    }

    // Binary search to check if any element lies in [val - d, val + d]
    private boolean isValid(int[] arr2, int val, int d) {
        int left = 0;
        int right = arr2.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Agar range [val - d, val + d] me element mil gaya
            if (Math.abs(arr2[mid] - val) <= d) {
                return false;
            }

            if (arr2[mid] < val) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return true;
    }
}