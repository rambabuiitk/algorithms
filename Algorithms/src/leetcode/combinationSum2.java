/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … ,ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/
import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int current = 0;
        compute(num, target, current, temp, res, 0);

        return res;
    }

     Map<String, Integer> map = new HashMap<String, Integer>();

    public void compute(int[] candidates, int target, int current,
            ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res, int index) {
        if (current > target)
            return;

        if (current == target) {
            ArrayList<Integer> list = new ArrayList<Integer>(temp);
            java.util.Collections.sort(list);
            String sig = list.toString();
            if (!map.containsKey(sig)) {
                res.add(list);
                map.put(sig, 1);
            }

            return;
        }

        int len = candidates.length;
        for (int i = index; i < len; i++) {
            int value = candidates[i];
            temp.add(value);
            current += value;
            compute(candidates, target, current, temp, res, i+1);
            temp.remove(temp.size() - 1);
            current -= value;
        }
    }
}
