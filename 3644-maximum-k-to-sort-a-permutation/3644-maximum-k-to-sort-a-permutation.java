class Solution {
    public int sortPermutation(int[] nums) {
        int ans = -1; // -1 represents all bits set to 1 in binary (0xFFFFFFFF)

        for (int i = 0; i < nums.length; i++) {
            // Sirf un elements ko consider karo jo apni sahi jagah par nahi hain
            if (nums[i] != i) {
                if (ans == -1) {
                    ans = nums[i];
                } else {
                    ans &= nums[i];
                }
            }
        }

        // Agar array already sorted tha, to ans change nahi hua hoga
        return ans == -1 ? 0 : ans;
    }
}