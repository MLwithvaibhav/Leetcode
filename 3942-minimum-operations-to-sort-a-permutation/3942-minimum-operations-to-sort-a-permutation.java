class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        // 1. Dhoondo 0 kahan baitha hai
        int zeroIdx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroIdx = i;
                break;
            }
        }

        // 2. Check karo kya 0 ke baad 1, 2, 3... sequence mein hain?
        boolean seedhaHai = true;
        for (int step = 0; step < n; step++) {
            // zeroIdx se shuru karke aage badho
            int currentIndex = (zeroIdx + step) % n;
            if (nums[currentIndex] != step) {
                seedhaHai = false;
                break;
            }
        }

        // 3. Check karo kya ulta sequence hai (...3, 2, 1, 0)?
        boolean ultaHai = true;
        for (int step = 0; step < n; step++) {
            // zeroIdx se peeche mudkar check karo
            int currentIndex = (zeroIdx - step + n) % n;
            if (nums[currentIndex] != step) {
                ultaHai = false;
                break;
            }
        }

        // Agar na seedha hai, na ulta hai -> Toh sort karna IMPOSSIBLE hai
        if (!seedhaHai && !ultaHai) {
            return -1;
        }

        int minOps = Integer.MAX_VALUE;

        // Agar seedha sequence hai:
        if (seedhaHai) {
            // Rasta 1: Bas zeroIdx baar Rotate Left dabao
            minOps = Math.min(minOps, zeroIdx);

            // Rasta 2: Reverse karo, rotate karo, fir reverse karo
            // (Isme lagenge: (n - zeroIdx) % n + 2)
            int rasta2 = (zeroIdx == 0) ? 0 : (n - zeroIdx) + 2;
            minOps = Math.min(minOps, rasta2);
        }

        // Agar ulta sequence hai:
        if (ultaHai) {
            // Rasta 1: Reverse karo pehle, fir bacha hua rotate
            int reversePePe = 1 + (n - 1 - zeroIdx);
            minOps = Math.min(minOps, reversePePe);

            // Rasta 2: Pehle rotate karo, fir reverse karo
            int rotateFirst = ((zeroIdx + 1) % n) + 1;
            minOps = Math.min(minOps, rotateFirst);
        }

        return minOps;
    }
}