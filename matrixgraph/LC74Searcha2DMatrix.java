import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC74Searcha2DMatrix {
    // Link : https://leetcode.com/problems/search-a-2d-matrix/description/
    //In this solution, we will be visualising 2D array as an 1D array
    //Then we will b treating end as row* col -1
    // and accordingly we will be calculating mid
    //e.g
    /*
    [[1  3  5  7]
     [10 11 16 20]
     [23 30 34 60]]
     we will be converting to [1, 3, 5, 7, 10, 11, 16, 20, 23, 30, 34, 60]
     we will calculate mid = start + end / 2
     once mid is calculated we will convert it into row and column format
     to convert it we will be takin colLength
     r = mid / colLength ;
     c = mid % colLength
     which means at matrix[r][c] we have our mid element
     once we found our mid element, we will compare it with our target.
     If target is same as mid then return true
     if target is less than mid then end = mid -1 and again converting mid to row and column format
    if target is greater than mid then start= mid + 1 and again converting mid to row column format
    //Time complexity log m * n

    */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowlen = matrix.length ;
        int collen = matrix[0].length ;
        int start = 0 ;
        int end = (rowlen * collen) - 1 ;
        while(start<=end){
            int mid = start + (end - start) / 2 ;
            int r = mid / collen ; // Convert the middle index to row and column indices:
            int c = mid % collen ;
            if(matrix[r][c] == target){
                return true ;
            }
            if(matrix[r][c]<target){
                start = mid + 1 ;
            }
            if(matrix[r][c]>target){
                end = mid - 1;
            }
        }
        return false ;
    }
}
