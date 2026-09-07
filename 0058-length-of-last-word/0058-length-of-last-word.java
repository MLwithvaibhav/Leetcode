class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int i = n - 1;
        int length = 0;

        // 1. Peeche ke trailing spaces skip karein
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // 2. Last word ke characters count karein
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}