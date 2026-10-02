import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // 1. Agar opening bracket hai toh stack mein push kar
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // 2. Agar closing bracket hai
            else {
                // Stack khali hai aur closing bracket mil gaya -> Invalid
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                // Check kar match ho raha hai ya nahi
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // End mein stack khali hona chahiye
        return stack.isEmpty();
    }
}