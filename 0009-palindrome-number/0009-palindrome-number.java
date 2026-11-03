class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers kabhi palindrome nahi ho sakte (jaise -121 != 121-)
        // Aur agar last digit 0 hai toh pehla bhi 0 hona chahiye, jo sirf x = 0 par possible hai
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        // Sirf aadhi number reverse karenge taaki 32-bit integer overflow na ho
        while (x > reversedHalf) {
            reversedHalf = (reversedHalf * 10) + (x % 10);
            x /= 10;
        }

        // Even length ke liye (x == reversedHalf)
        // Odd length ke liye middle digit discard karke (x == reversedHalf / 10)
        return x == reversedHalf || x == reversedHalf / 10;
    }
}