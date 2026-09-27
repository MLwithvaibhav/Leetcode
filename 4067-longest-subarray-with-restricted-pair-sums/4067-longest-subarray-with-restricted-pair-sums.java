class Solution {
    public int maxSubarray(int[] nums) {
        int n = nums.length;
        int[] freq = new int[501];

        int left = 0, res = 0;

        for (int right = 0; right < n; right++) {
            int x = nums[right];

            while (!canADD(x, freq)) {
                freq[nums[left]]--;
                left++;
            }

            freq[x]++;
            res = Math.max(res, right - left + 1);
        }

        return res;
    }

    private boolean canADD(int x, int[] freq) {
        for (int a = 1; a <= 500; a++) {
            if (freq[a] == 0) {
                continue;
            }

            int b = x - a;

            if (b < 1 || b > 500 || freq[b] == 0) {
                continue;
            }

            if (a != b || freq[a] >= 2) {
                return false;
            }
        }

        for (int a = 1; a <= 500; a++) {
            if (freq[a] == 0)
                continue;

            int b = x + a;

            if (b <= 500 && freq[b] > 0) {
                return false;
            }
        }

        return true;
    }
}