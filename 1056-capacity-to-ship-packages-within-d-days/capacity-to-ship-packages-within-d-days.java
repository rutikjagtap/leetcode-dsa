class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for (int num : weights) {
            low = Math.max(low, num);
            high += num;
        }
        while(low <= high){
            int mid = low + (high - low)/2;
            if(ispoosible(weights,days,mid)){
                high = mid -1;
            }
            else{
                low = mid +1;
            }
        }
        return low;
    }
    public boolean ispoosible(int[] weights,int days,int mid){
        int current =0;
        int required = 1;
        for(int num : weights){
            if(current + num > mid){
                current = num;
                required++;
            }
            else{
                current += num;
            }
        }
        return required <= days;
    }
}