import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base boundary
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop(); // Matching open ya boundary pop kiya
                
                if (stack.isEmpty()) {
                    stack.push(i); // Nayi boundary set kar di
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}