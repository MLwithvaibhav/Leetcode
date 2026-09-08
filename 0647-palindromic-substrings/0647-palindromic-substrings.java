class Solution {
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();

        int i = 0;
        while (i < n - 1) {
            int j = i + 1;
            while (j < n) {
                if (isPalindrome(s, i, j)) {
                    count++;
                }
                j++;
            }
            i++;
        }

        return count + n;
    }
}