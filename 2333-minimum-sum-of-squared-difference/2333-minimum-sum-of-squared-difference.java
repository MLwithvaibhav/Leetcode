class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 0;
        
        // 1. Har pair ka difference nikaal lo aur maximum difference dhoondho
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }
        
        // 2. Dono k ko jod do (long mein taaki overflow na ho)
        long k = (long) k1 + k2;
        
        // 3. Count array banao (Buckets: kis size ka difference kitni baar aaya)
        // Agar maxDiff 4 hai, toh size 5 banega (index 0 se 4 tak)
        int[] count = new int[maxDiff + 1];
        for (int d : diff) {
            count[d]++;
        }
        
        // 4. Sabse bade difference se niche ki taraf aao
        for (int d = maxDiff; d > 0 && k > 0; d--) {
            // Agar iss size ka koi difference hai hi nahi, aage badho
            if (count[d] == 0) continue;
            
            // Case A: Hamare paas itna k bacha hai ki hum saare `count[d]` elements ko 1 se kam kar sakte hain
            if (k >= count[d]) {
                k -= count[d];            // count[d] moves kharch ho gaye
                count[d - 1] += count[d]; // ye saare ab (d - 1) ban gaye
                count[d] = 0;             // ab d size ka koi nahi bacha
            } 
            // Case B: Moves kam pad gaye! Jitne reduce ho sakte hain sirf utne karo
            else {
                count[d - 1] += (int) k;  // sirf k elements hi (d - 1) ban paaye
                count[d] -= (int) k;      // baaki bache hue abhi bhi d hi rahenge
                k = 0;                    // k pura khatam
            }
        }
        
        // 5. Final Square Sum calculate karo
        long ans = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (count[d] > 0) {
                // long cast zaroori hai taaki d * d overflow na ho
                ans += (long) count[d] * (long) d * d;
            }
        }
        
        return ans;
    }
}