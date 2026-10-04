class Solution {
    public int tribonacci(int n) { //
        // Base cases di gayi definition ke hisaab se[cite: 5]
        if (n == 0) {
            return 0; // T_0 = 0[cite: 5]
        }
        if (n == 1 || n == 2) {
            return 1; // T_1 = 1, T_2 = 1[cite: 5]
        }
        
        // Shuruat ke 3 values ko variables mein store kar liya
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        
        // Loop 3 se n tak chalega kyunki 0, 1, 2 hum handle kar chuke hain
        for (int i = 3; i <= n; i++) {
            // Next number calculate karo: T_n+3 = T_n + T_n+1 + T_n+2[cite: 5]
            int next = t0 + t1 + t2; 
            
            // Variables ko ek step aage shift karo next iteration ke liye
            t0 = t1;
            t1 = t2;
            t2 = next;
        }
        
        return t2;
    }
}