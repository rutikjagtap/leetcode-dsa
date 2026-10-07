class Solution {
    public int removeElement(int[] nums, int val) {
        int[] arr = new int[nums.length];
        int k= 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}