class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);

                i++;
                j++;

                while (i < nums1.length && nums1[i] == nums1[i - 1]) {
                    i++;
                }

                while (j < nums2.length && nums2[j] == nums2[j - 1]) {
                    j++;
                }
            }

            else if (nums1[i] < nums2[j]) {
                i++;
            }

            else {
                j++;
            }
        }

        int[] ans = new int[result.size()];

        for (int k = 0; k < result.size(); k++) {
            ans[k] = result.get(k);
        }

        return ans;
    }
}