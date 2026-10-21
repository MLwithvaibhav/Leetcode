class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        generateSubsets(0, nums, current, result);
        return result;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Base case: jab saare elements traverse ho gaye
        if (index == nums.length) {
            // Note: Java me reference pass hota hai, isliye deep copy banate hain!
            result.add(new ArrayList<>(current));
            return;
        }

        // 1. Choice: Element ko include karo
        current.add(nums[index]);
        generateSubsets(index + 1, nums, current, result);

        // Backtrack: recursion se wapas aate waqt element ko hata do
        current.remove(current.size() - 1);

        // 2. Choice: Element ko exclude karo
        generateSubsets(index + 1, nums, current, result);
    }
}