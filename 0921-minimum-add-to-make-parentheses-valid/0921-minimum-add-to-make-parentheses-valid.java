class Solution {
    public int minAddToMakeValid(String s) {
        int openNeeded = 0;  // Tracks unmatched ')' that need a '('
        int closeNeeded = 0; // Tracks unmatched '(' that need a ')'

        for (char c : s.toCharArray()) {
            if (c == '(') {
                closeNeeded++;
            } else if (c == ')') {
                if (closeNeeded > 0) {
                    // There is a matching open parenthesis available
                    closeNeeded--;
                } else {
                    // No matching open parenthesis, so we need to add one
                    openNeeded++;
                }
            }
        }

        // The total additions required is the sum of unmatched '(' and ')'
        return openNeeded + closeNeeded;
    }
}