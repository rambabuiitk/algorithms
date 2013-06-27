/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/
public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] res = new int[]{-1, -1};
        int size = A.length;
        if (target < A[0] || target > A[size -1])
            return res;
        
        int begin = 0;
        int end = size -1;
        while (begin <= end) {
            int mid = begin + (end-begin)/2;
            if (mid > 0 && A[mid] == target && A[mid-1] < target) {
                res[0] = mid;
                break;
            } 
            
            if (A[mid] >= target) {
                end = mid -1;
            } else {
                begin = mid+1;
            }
        }

        if (end < size-1 && A[end+1] == target && res[0] == -1)
            res[0] = end + 1;
            
        begin = 0;
        end = size -1;
        while (begin <= end) {
            int mid = begin + (end-begin)/2;
            if (mid+1 < size && A[mid] == target && A[mid+1] > target) {
                res[1] = mid;
                break;
            } 
            
            if (A[mid] <= target) {
                begin = mid+1;
            } else {
                end = mid-1;
            }
        }
        if (begin > 0 && A[begin-1] == target && res[1] == -1)
            res[1] = begin- 1;
        return res;
    }
}
