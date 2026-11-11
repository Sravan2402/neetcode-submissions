class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r1=0,c1=matrix[0].length-1;
        int rowLen=matrix.length;
        int colLen=matrix[0].length;
        while(r1<rowLen && c1>=0){
            if(matrix[r1][c1]==target){
                return true;
            }
            if(matrix[r1][c1]>target){
                c1--;
            }
            else if(matrix[r1][c1]<target){
                r1++;
            }
        }
        return false;
    }
}
