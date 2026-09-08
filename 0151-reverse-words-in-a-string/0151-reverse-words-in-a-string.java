import java.util.ArrayList;

class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder currentWord = new StringBuilder();
        ArrayList<String> words = new ArrayList<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch != ' ') {
                currentWord.append(ch);
            } else {
                if (currentWord.length() > 0) {
                    words.add(currentWord.toString());
                    currentWord.setLength(0); 
                }
            }
        }

        if (currentWord.length() > 0) {
            words.add(currentWord.toString());
        }

        for (int i = words.size() - 1; i >= 0; i--) {
            ans.append(words.get(i));
            if (i > 0) {
                ans.append(" "); 
            }
        }

        return ans.toString();
    }
}