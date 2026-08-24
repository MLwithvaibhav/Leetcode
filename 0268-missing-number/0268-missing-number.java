class Solution {
    public int missingNumber(int[] nums) {

        int n = nums.length;
        int TotalSum = n * (n + 1) / 2;
        int Sum = 0;

        for(int num:nums){
            Sum+=num;

        }
        return (TotalSum - Sum);
        
    }
}