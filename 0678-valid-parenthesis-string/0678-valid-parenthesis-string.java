class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openStack.push(i);
            } else if (ch == '*') {
                starStack.push(i);
            } else { // Matlab ch == ')' mila
                if (!openStack.isEmpty()) {
                    openStack.pop(); // Pehle asli '(' se match karo
                } else if (!starStack.isEmpty()) {
                    starStack.pop(); // Agar '(' nahi hai toh '*' ko use kar lo
                } else {
                    return false; // Dono khali hain matlab is ')' ko koi band nahi kar sakta
                }
            }
        }

        // Loop khatam hone ke baad: bache hue '(' ko '*' se cancel karo
        while (!openStack.isEmpty() && !starStack.isEmpty()) {
            // Agar '(' ka index '*' ke index se bada hai (matlab "*(" aisa scene hai)
            // toh '*' kabhi bhi '(' ko close nahi kar sakta!
            if (openStack.peek() > starStack.peek()) {
                return false;
            }
            openStack.pop();
            starStack.pop();
        }

        // Agar saare '(' khatam ho gaye, toh string valid hai!
        return openStack.isEmpty();
    }
}