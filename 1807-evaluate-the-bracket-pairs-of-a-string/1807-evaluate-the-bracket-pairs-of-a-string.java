import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        // Step 1: Map banao fast lookup ke liye
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean insideBracket = false;

        // Step 2: String parse karo
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                insideBracket = true;
            } else if (ch == ')') {
                insideBracket = false;
                String currentKey = key.toString();
                // Map me mila toh value, warna '?'
                result.append(map.getOrDefault(currentKey, "?"));
                key.setLength(0); // Key buffer reset karo
            } else {
                if (insideBracket) {
                    key.append(ch);
                } else {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }
}