class Solution {
    public int minOperations(String s) {

        int n = s.length();
       
        char minChar = 'z';
        char maxChar = 'a';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch < minChar) {
                minChar = ch;
            }
            if (ch > maxChar) {
                maxChar = ch;
            }
        }

        boolean isSorted = true;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                isSorted = false;
                break;
            }
        }

        if (isSorted == true) {
            return 0;
        } 

         if (s.length() == 2) {
            return -1;
        }

        if (s.charAt(0) == minChar || s.charAt(n - 1) == maxChar) {
            return 1; //[cite: 1]
        }

        // 5. Middle part (index 1 se lekar n-2) me count kar lo
        int middleCount = 0;
        for (int i = 1; i < n - 1; i++) {
            char ch = s.charAt(i);
            if (ch == minChar || ch == maxChar) {
                middleCount++;
            }
        }

        // Agar middle me koi bhi ek mil gaya toh 2 ops, warna worst case 3 ops
        if (middleCount > 0) {
            return 2;
        } else {
            return 3;
        }
    }
}