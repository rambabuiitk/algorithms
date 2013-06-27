/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … ,ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/
import java.util.*;

public class CombinationSum {

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
            int target) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int current = 0;
        compute(candidates, target, current, temp, res);

        return res;
    }

    static Map<String, Integer> map = new HashMap<String, Integer>();

    public static void compute(int[] candidates, int target, int current,
            ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res) {
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
        for (int i = 0; i < len; i++) {
            int value = candidates[i];
            temp.add(value);
            current += value;
            compute(candidates, target, current, temp, res);
            temp.remove(temp.size() - 1);
            current -= value;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] candidates = {2,3,6,7};
        ArrayList<ArrayList<Integer>> res  = combinationSum(candidates, 7);
        for (ArrayList<Integer> list:res) {
            System.out.println(list);
        }
    }

}

