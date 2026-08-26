class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

       List<List<Integer>> list = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int num : nums1){
            if(!containsNum(nums2, num) && !list1.contains(num)){
                list1.add(num);
            }
        }

        for(int num : nums2){
            if(!containsNum(nums1, num) && !list2.contains(num)){
                list2.add(num);
            }
        }

        list.add(list1);
        list.add(list2);
        return list;

        


        
    }
    public boolean containsNum(int nums[], int x){
        for(int num : nums){
            if(num ==  x)return true;
        }
        return false;
    }
}