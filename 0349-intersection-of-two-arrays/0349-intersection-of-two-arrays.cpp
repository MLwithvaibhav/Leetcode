class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> st;      // nums1 ke liye
        unordered_set<int> result;  // final answer

        // nums1 ko memory bana do
        for (int i = 0; i < nums1.size(); i++) {
            st.insert(nums1[i]);
        }

        // nums2 se test karo
        for (int i = 0; i < nums2.size(); i++) {
            if (st.find(nums2[i]) != st.end()) {
                result.insert(nums2[i]);
            }
        }

        // set → vector convert
        vector<int> ans(result.begin(), result.end());
        return ans;
    }
};
