#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
   vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> mp;

        for (int i = 0; i < nums.size(); i++) {
            int current = nums[i];
            int required = target - current;

            if (mp.find(required) != mp.end()) {
                return { mp[required], i };
            }

            mp[current] = i;
        }

        return {};
   }
};
