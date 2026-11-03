class Solution {
    public int minMoves(int[] nums) {
        int maxnum =0;
        for(int i=0;i<nums.length;i++){
            maxnum = Math.max(maxnum,nums[i]);
        }
        int count = 0;
        for(int i=0;i<nums.length;i++){
            while(nums[i] < maxnum){
                count ++;
                nums[i]++;
            }
        }
        return count;
    }
}