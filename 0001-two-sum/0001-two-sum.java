import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // <Number, Index>

        for (int i = 0; i < nums.length; i++) {
            int moreNeeded = target - nums[i];

            // 1. Agar partner map me pehle se hai, seedha dono indices return karo
            if (map.containsKey(moreNeeded)) {
                return new int[] { map.get(moreNeeded), i };
            }

            // 2. Partner nahi mila, toh apna number aur index map me daal do
            map.put(nums[i], i);
        }

        return new int[] {}; // Khali array agar koi pair na mile
    }
}