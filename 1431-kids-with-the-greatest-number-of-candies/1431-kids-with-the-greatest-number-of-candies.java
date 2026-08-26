class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> l1 = new ArrayList<>();

        int largest = 0;
        for(int num : candies){
            if(num > largest){
                largest = num;
            }
        }

        for(int i = 0; i<candies.length; i++){
            if(extraCandies + candies[i] >= largest){
                l1.add(true);
            }
            else{
                l1.add(false);
            }
        }
        return l1;

        
    }
}