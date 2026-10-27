class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left =0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for(int right =0;right<nums.length;right++){
            sum += nums[right];
            while(sum >= target){
                sum -= nums[left];
                minLen = Math.min(minLen,right - left +1);
                left++;
            }
        }
        if(minLen == Integer.MAX_VALUE){
            return 0;
        }
        else{
            return minLen;
        }
    }
}