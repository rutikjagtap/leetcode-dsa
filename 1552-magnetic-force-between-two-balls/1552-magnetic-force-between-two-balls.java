class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = position[position.length-1] - position[0];
        while(low <= high){
            int mid = low + (high - low)/2;
            if(ispossible(position,m,mid)){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return high;
    }
    public boolean ispossible(int[] position, int m, int mid){
        int ball = 1;
        int last = position[0];
        for(int i=0;i<position.length;i++){
            if(position[i] - last >= mid){
                ball++;
                last = position[i];
            }
        }
        return ball>= m;
    }
}