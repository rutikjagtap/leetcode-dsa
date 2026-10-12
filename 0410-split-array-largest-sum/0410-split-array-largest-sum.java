class Solution {
    public int splitArray(int[] nums, int k) {
        int low =0;
        int high = 0;
        for(int num : nums){
            low = Math.max(low,num);
            high += num;
        }
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(ispossible(nums,k,mid)){
                ans = mid;
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return ans;
    }
    public boolean ispossible(int[]nums,int k,int mid){
        int subarray =1;
        int current =0;
        for(int num : nums){
            if(current + num > mid){
                subarray++;
                current = num;
            }
            else{
                current += num;
            }
            if(subarray > k){
                return false;
            }
        }
        return true;
    }
}