class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int count =1;
        int maxLen = 1;
        for(int i=0;i<nums.length -1;i++){
            if(nums[i] > nums[i+1]){
                count++;
            }
            else{
                count = 1;
            }
            maxLen = Math.max(maxLen,count);
        }
        count = 1;
        for(int i=0;i<nums.length -1;i++){
            if(nums[i] < nums[i+1]){
                count++;
            }
            else{
                count = 1;
            }
            maxLen = Math.max(maxLen,count);
        }
        return maxLen;
    }
}