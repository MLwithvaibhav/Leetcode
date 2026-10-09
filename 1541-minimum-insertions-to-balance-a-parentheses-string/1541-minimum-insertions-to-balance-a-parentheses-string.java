class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int open = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                // Agar s.charAt(i) == ')' hai
                // Check karo kya agla bhi ')' hai?
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++; // Agla wala ')' bhi consume ho gaya
                } else {
                    // Akela ')' tha, to ek ')' insert karna padega
                    ans++;
                }

                // Ab hamare paas '))' ka pair ready hai
                // Dekho kya iske peeche koi '(' tha?
                if (open > 0) {
                    open--; // Purana '(' match ho gaya
                } else {
                    ans++;  // Koi '(' nahi tha, to ek '(' insert karna padega
                }
            }
        }

        // Jitne '(' bach gaye, un sabko 2-2 ')' dene padenge
        ans += open * 2;

        return ans;
    }
}