class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) { //[cite: 4]
        List<List<Integer>> result = new ArrayList<>();
        // Start exploring from number 1
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> currentCombo, int k, int remain, int start) {
        // Base Case 1: Agar combination me exactly 'k' numbers ho gaye hain
        if (currentCombo.size() == k) {
            // Aur unka sum required 'n' ke barabar hai (yaani remaining sum 0 ho gaya)
            if (remain == 0) {
                result.add(new ArrayList<>(currentCombo)); // Valid combination mil gaya
            }
            return; // 'k' numbers poore ho gaye, aage aur numbers add nahi karne hain
        }
        
        // Sirf 1 se 9 tak numbers use karne hain[cite: 4]
        for (int i = start; i <= 9; i++) {
            // Optimization (Pruning): Agar current number hi remaining sum se bada hai, 
            // toh aage ke numbers try karne ka koi fayda nahi kyunki numbers badhte jayenge.
            if (remain - i < 0) {
                break;
            }
            
            // Choose: Current number ko combination mein add karo
            currentCombo.add(i);
            
            // Explore: Next number try karo (i + 1 kyunki ek number ek hi baar use kar sakte hain[cite: 4])
            // aur remaining sum ko update (remain - i) karo
            backtrack(result, currentCombo, k, remain - i, i + 1);
            
            // Un-choose (Backtrack): Wapas aate waqt aakhri add kiye gaye number ko hatao
            currentCombo.remove(currentCombo.size() - 1);
        }
    }
}