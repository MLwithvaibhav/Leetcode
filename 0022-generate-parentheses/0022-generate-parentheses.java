import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base Case: String poori ban gayi
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // Choice 1: '(' add karo agar max se kam hai
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // Choice 2: ')' add karo agar open brackets zyada hain
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}