class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int j = 0; // khareedne ka din (buy pointer)
        int i = 1; // bechne ka din (sell pointer)
        int maxProfit = 0;

        while (i < n) {
            int minPrice = prices[j];       // buy price
            int currentPrice = prices[i];   // sell price

            
            if (currentPrice - minPrice > maxProfit) {
                maxProfit = currentPrice - minPrice;
            } 
            
            else if (currentPrice < minPrice) {
                j = i; 
            }

            // Agle din check karne ke liye i ko aage badhao
            i++;
        }

        return maxProfit;
    }
}