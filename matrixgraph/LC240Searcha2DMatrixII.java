import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC240Searcha2DMatrixII {
    /*
    Link : https://leetcode.com/problems/search-a-2d-matrix-ii/description/
   The matrix is assumed to be sorted in a way that each row is sorted in ascending order, and each column is sorted in descending order.
   Time Complexity : O(M+N)
   Space Complexity : O(1)
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length ; //number of rows in the matrix.
        int n = matrix[0].length ; //number of columns in the matrix.
        int r = 0;
        int c = n-1 ;
        while(r < m && c >= 0){ //a loop that continues until either the entire matrix is searched or the target is found.
            if(matrix[r][c] == target){ //Check if the element at the current position (r, c) is equal to the target
                return true ;
            }
            else if(matrix[r][c] < target) //If the element at the current position is less than the target, it means that the target, if present, must be in the //
            //rows below the current one. Therefore, increment the row index r to move down in the matrix:
            {
                r++ ;
            }
            else{
                c -- ;   //If the element at the current position is greater than the target, it means that the target, if present, must be in the columns to the
                //left of the current one. Therefore, decrement the column index c to move left in the matrix:


            }
        }
        return false ;
    }
}
