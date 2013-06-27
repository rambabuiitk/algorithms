// Time Limit Exceeded
/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length;
        int n = matrix[0].length;
        
        if (target < matrix[0][0] || target > matrix[m-1][n-1])
            return false;
        
        
        int lower = 0;
        int upper = m*n -1;
        while (lower <= upper) {
            int mid = lower + (upper-lower)>>1;
            if (target == matrix[mid%m][mid%n]) {
                return true;
            } else if (target < matrix[mid%m][mid%n]) {
                upper = mid-1;
            } else { 
                lower = mid+1;
            }   
        }
        
        return false;
    }
}
