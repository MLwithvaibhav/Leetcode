class Solution {
    public List<String> letterCombinations(String digits) { //
        List<String> result = new ArrayList<>();
        
        // Base case: agar string empty hai toh empty list return kardo
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        // Digits (0-9) ki mapping letters ke sath jaisa keypad par hota hai
        String[] mapping = {
            "",     // 0
            "",     // 1 (does not map to any letters)[cite: 3]
            "abc",  // 2[cite: 3]
            "def",  // 3[cite: 3]
            "ghi",  // 4[cite: 3]
            "jkl",  // 5[cite: 3]
            "mno",  // 6[cite: 3]
            "pqrs", // 7[cite: 3]
            "tuv",  // 8[cite: 3]
            "wxyz"  // 9[cite: 3]
        };
        
        // Backtracking function call
        backtrack(result, digits, new StringBuilder(), 0, mapping);
        
        return result;
    }
    
    private void backtrack(List<String> result, String digits, StringBuilder currentCombo, int index, String[] mapping) {
        // Agar current combination ki length digits ki length ke barabar ho gayi, 
        // toh iska matlab ek valid combination ban gaya hai.
        if (index == digits.length()) {
            result.add(currentCombo.toString());
            return;
        }
        
        // Current digit nikalo (character se integer me convert karke)
        int digit = digits.charAt(index) - '0';
        String letters = mapping[digit];
        
        // Current digit ke saare possible letters par loop lagao
        for (char c : letters.toCharArray()) {
            currentCombo.append(c); // Character add karo (Choose)
            
            backtrack(result, digits, currentCombo, index + 1, mapping); // Aage badho (Explore)
            
            currentCombo.deleteCharAt(currentCombo.length() - 1); // Wapas aate waqt character remove karo (Un-choose / Backtrack)
        }
    }
}