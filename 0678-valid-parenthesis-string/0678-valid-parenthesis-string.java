class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                minOpen--; // Agar '*' ko ')' maana
                maxOpen++; // Agar '*' ko '(' maana
                // Agar '*' ko "" maana, toh count change nahi hoga (jo is range ke andar hi aata hai)
            }

            // Agar maxOpen hi negative ho gaya, matlab ')' zyada ho gaye jo balance nahi ho sakte
            if (maxOpen < 0) {
                return false;
            }

            // minOpen 0 se chhota nahi ho sakta kyunki hum extra ')' assume nahi karenge
            if (minOpen < 0) {
                minOpen = 0;
            }
        }

        // Agar minOpen 0 tak pahunch sakta hai, matlab saare brackets successfully balance ho gaye
        return minOpen == 0;
    }
}