class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open, int close, int n) {
        // Base case: jab poori string ban jaye
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // Branch 1: '(' lagana agar open < n ho
        if (open < n) {
            current.append('(');
            backtrack(result, current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1); // Backtrack / Undo
        }

        // Branch 2: ')' lagana agar close < open ho
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1); // Backtrack / Undo
        }
    }
}