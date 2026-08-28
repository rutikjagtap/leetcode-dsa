class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> map = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            map.add(nums[i]);
        }
        int x = k;
        while (true) {
            if (!map.contains(x)) {
                return x;
            }
            x += k;
        }
    }
}