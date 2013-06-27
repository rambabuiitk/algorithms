/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/
public class Solution {
    public int search(int[] A, int key) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int N = A.length;
        int L = 0;
        int R = N - 1;

        while (L <= R) {
            // Avoid overflow, same as M=(L+R)/2
            int M = L + ((R - L) >> 1); 
            if (A[M] == key) return M;

            // the bottom half is sorted
            if (A[L] <= A[M]) {
                if (A[L] <= key && key < A[M])
                    R = M - 1;
                else
                    L = M + 1;
            }   
            // the upper half is sorted
            else {
                if (A[M] < key && key <= A[R])
                    L = M + 1;
                else
                    R = M - 1;
            }   
        }
        return -1;
    }
}
