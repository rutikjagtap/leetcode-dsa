class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minsum = Integer.MAX_VALUE;
        for(int i=l;i<=r;i++){
            int sum = 0;
            for(int j=0;j<i;j++){
                sum += nums.get(j);
            }
            if(sum >0){
                minsum = Math.min(minsum,sum);
            }
            for(int k =i;k<nums.size();k++){
                sum += nums.get(k) - nums.get(k-i);
                if(sum > 0){
                    minsum = Math.min(minsum,sum);
                }
            }
        }
        if(minsum == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return minsum;
        }
    }
}