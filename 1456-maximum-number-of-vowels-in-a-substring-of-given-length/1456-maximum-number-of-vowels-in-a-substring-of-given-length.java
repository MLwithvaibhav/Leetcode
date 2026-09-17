class Solution {
    public int maxVowels(String s, int k) {

        int count = 0;
        int maxCount = 0;

        // 1. Pehli window
        for (int i = 0; i < k; i++) {
            if ("aeiou".indexOf(s.charAt(i)) != -1) {
                count++;
            }
        }
        maxCount = count;

        // 2. Window slide karo (s.length() brackets ke saath)
        for (int i = k; i < s.length(); i++) {
            // Naya character add
            if ("aeiou".indexOf(s.charAt(i)) != -1) {
                count++;
            }

            // Purana character drop
            if ("aeiou".indexOf(s.charAt(i - k)) != -1) {
                count--;
            }

            // Har slide ke baad max update karo
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}