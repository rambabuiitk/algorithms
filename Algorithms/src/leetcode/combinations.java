/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int current = 0;
        compute(n, k, current, temp, res, 0);
        return res;
    }
    
    public static void compute(int n, int k, int current,
            ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res, int index) {
        if (current > k)
            return;

        if (current == k) {
            ArrayList<Integer> list = new ArrayList<Integer>(temp);
            res.add(list);
            return;
        }

        for (int i = index; i < n; i++) {
            temp.add(i+1);
            current += 1;
            compute(n, k, current, temp, res, i+1);
            temp.remove(temp.size() - 1);
            current -= 1;
        }
    }
}
