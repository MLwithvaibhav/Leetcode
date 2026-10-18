class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;

        int i = 0;
        int n = s.length();

        // 1. Whitespace skip
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i == n) return 0;

        // 2. Sign check
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3. Recursive helper for digits
        return helper(s, i, 0L, sign);
    }

    private int helper(String s, int i, long res, int sign) {
        // Base case: string end ho gayi ya non-digit char aa gaya
        if (i >= s.length() || !Character.isDigit(s.charAt(i))) {
            return (int) (res * sign);
        }

        int digit = s.charAt(i) - '0';
        res = res * 10 + digit;

        // Base case: Overflow clamp
        if (sign == 1 && res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (sign == -1 && -res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        // Recursive call for next character
        return helper(s, i + 1, res, sign);
    }
}