class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Duplicate 'i' ko skip karo
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Pointers hain ye, values nahi!
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                // Sum har iteration me naya niklega
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Duplicate elements skip karo taaki same triplet repeat na ho
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Sum chhota hai, bada number chahiye
                } else {
                    right--; // Sum bada hai, chhota number chahiye
                }
            }
        }

        return result;
    }
}