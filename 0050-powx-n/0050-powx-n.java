class Solution {
    public double myPow(double x, int n) {
        long power = n;
        if (n == 0) {
            return 1.0;
        }

        if (n < 0) {
            return 1 / func(x, -power);
        }

        return func(x, power);
    }

    public double func(double x, long n){
        if(n == 0){
            return 1;
        }

        if(n % 2 == 0){
            return func(x*x, n/2);
        }
        else{
            return x * func(x*x, n/2);
        }
    }
}