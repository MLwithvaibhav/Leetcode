class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int sum = 0;
        double avg = 0;
        double maxAvg = 0;
        for(int i = 0; i<k; i++){
            sum+=nums[i];
            
        }

        maxAvg = (double) sum/k;

        for(int i = k; i<nums.length; i++){
            sum+=nums[i];
            sum-=nums[i-k];
            avg = (double) sum/k;
            if(avg>maxAvg){
                maxAvg = avg;
            }
        }
        return maxAvg;
    }
}