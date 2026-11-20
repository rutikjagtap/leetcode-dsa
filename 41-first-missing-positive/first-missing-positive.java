class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxnum = 0;
        int ans =0;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i= 1;i<= nums.length +1;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }
}