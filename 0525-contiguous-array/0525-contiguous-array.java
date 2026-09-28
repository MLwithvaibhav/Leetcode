class Solution {
    public int findMaxLength(int[] nums) {

        int maxLen = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);

        for(int i = 0; i<nums.length; i++){
            sum += (nums[i] == 0)?-1:1;


            if(map.containsKey(sum)){
                int len = i-map.get(sum);
                maxLen = Math.max(len, maxLen);
            }
            else{
                map.put(sum, i);
            }
        }
        return maxLen;
        
    }
}