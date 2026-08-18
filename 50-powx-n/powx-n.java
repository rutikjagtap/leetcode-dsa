class Solution {
    public double myPow(double x, int n) {
        return power(x,(long)n);
    }
    private double power(double x, long n){
        if(n==0){
            return 1;
        }
        if(n<0){
            x = 1/x;
            n = -n;
        }
        double half = power(x,n/2);
        if(n % 2 == 0){
            return half *half;   
        }
        else{
            return half * half * x;
        }

    }
}