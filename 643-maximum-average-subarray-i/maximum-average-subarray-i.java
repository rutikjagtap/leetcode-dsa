class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum =0;
        for(int i=0;i<k;i++){
            sum += nums[i];
        }
        int maxv = sum;
        for(int i=k;i<nums.length;i++){
            sum = sum -nums[i-k]+ nums[i];
            maxv = Math.max(maxv,sum);
        }
        double ans = (double)maxv /k;
        return ans;
    }
}