class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int ans = 0;
        HashSet<Integer> set = new HashSet<>(); // Ek hi baar bahar banaya

        for (int i = 0; i < n; i++) {
            set.clear(); // Manually purana kachra saaf kiya naye starting point ke liye
            
            for (int j = i; j < n; j++) {
                set.add(nums.get(j));
                int distinct = set.size();
                ans += distinct * distinct;
            }
        }
        return ans;
    }
}