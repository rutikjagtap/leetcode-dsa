class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = (n*m) -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            int midvalue = matrix[mid/n][mid%n];
            if(midvalue == target){
                return true;
            }
            else if(midvalue < target){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return false;
    }
}