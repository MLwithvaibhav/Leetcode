class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            // Har naye starting point 'i' ke liye naya fresh set
            HashSet<Integer> set = new HashSet<>();
            
            for (int j = i; j < n; j++) {
                set.add(nums.get(j)); // element add kiya
                int distinct = set.size();
                ans += distinct * distinct; // square add kiya
            }
        }
        return ans;
    }
}