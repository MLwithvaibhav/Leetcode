class Solution {
    private static final long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long eveCount = (n+1)/2;
        long oddCount = n/2;

        long evenWays = modPow(5, eveCount);
        long oddWays = modPow(4, oddCount);

        return (int) ((evenWays * oddWays)%MOD);
    }
    public long modPow(long base, long expo){
        if(expo == 0){
            return 1;
        }

        long half = modPow(base, expo/2);
        long res = ((half * half)%MOD);

        if(expo % 2 == 1){
           res = (res * base) % MOD;
        }
        return res;
    }
}