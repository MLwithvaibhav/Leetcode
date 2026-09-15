class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int count = 0;
        int lastEnd = -1; // Pichla palindrome jahan khatam hua uska index

        for (int i = 0; i < n; i++) {
            // Odd length palindrome check (center i)
            int l = i, r = i;
            while (l > lastEnd && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 >= k) {
                    count++;
                    lastEnd = r;
                    break;
                }
                l--;
                r++;
            }

            // Even length palindrome check (center i aur i+1)
            l = i;
            r = i + 1;
            while (l > lastEnd && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 >= k) {
                    count++;
                    lastEnd = r;
                    break;
                }
                l--;
                r++;
            }
        }

        return count;
    }
}