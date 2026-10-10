class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long[] diff = new long[n];
        long totalDiffSum = 0;
        
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            totalDiffSum += diff[i];
        }
        
        long k = (long) k1 + k2;
        
        // Agar k itna bada hai ki saare differences 0 ho sakte hain, toh direct 0
        if (totalDiffSum <= k) return 0;
        
        // Binary Search lagao us ceiling 'M' par jo hum achieve kar sakte hain
        long low = 0, high = 100000;
        long targetCeil = high;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            // Dekho mid tak laane ke liye kitne moves chahiye
            long needed = 0;
            for (int i = 0; i < n; i++) {
                if (diff[i] > mid) {
                    needed += (diff[i] - mid);
                }
            }
            
            if (needed <= k) {
                targetCeil = mid; // possible hai, aur chota try karo
                high = mid - 1;
            } else {
                low = mid + 1;    // moves kam pad gaye, ceiling badi karni padegi
            }
        }
        
        // targetCeil mil gaya! Ab sabko targetCeil bana do aur k kharch karo
        for (int i = 0; i < n; i++) {
            if (diff[i] > targetCeil) {
                k -= (diff[i] - targetCeil);
                diff[i] = targetCeil;
            }
        }
        
        // Jo k thoda sa bacha reh gaya, use kisi bhi targetCeil wale se 1-1 minus kar do
        for (int i = 0; i < n && k > 0; i++) {
            if (diff[i] == targetCeil && diff[i] > 0) {
                diff[i]--;
                k--;
            }
        }
        
        // Final square sum
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += diff[i] * diff[i];
        }
        
        return ans;
    }
}