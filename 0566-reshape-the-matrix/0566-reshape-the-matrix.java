class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] result = new int[r][c];
        if(n*m != r*c){
            return mat;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int index = i*m+j;
                int rows = index/c;
                int cols = index%c;

                result[rows][cols] = mat[i][j];
            }
        }
        return result;
    }
}