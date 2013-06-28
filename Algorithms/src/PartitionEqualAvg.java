import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class PartitionEqualAvg {

    /**
     * just prints a solution
     * 
     * @param list
     * @param indexes
     */
    public static void printSolution(List<Integer> list, HashSet<Integer> indexes) {
        Iterator<Integer> iter = indexes.iterator();
        while (iter.hasNext()) {
            System.out.print(list.get(iter.next()) + " ");
        }
        System.out.println();
    }

    /**
     * calculates the average of a list, but only taking into account the values
     * of at the given indexes
     * 
     * @param list
     * @param indexes
     * @return
     */
    public static float avg(List<Integer> list, HashSet<Integer> indexes) {
        Iterator<Integer> iter = indexes.iterator();
        float sum = 0;
        while (iter.hasNext()) {
            sum += list.get(iter.next());
        }
        return sum / indexes.size();
    }

    /**
     * calculates the average of a list, ignoring the values of at the given
     * indexes
     * 
     * @param list
     * @param indexes
     * @return
     */
    public static float avg_e(List<Integer> list, HashSet<Integer> indexes) {
        float sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!indexes.contains(i)) {
                sum += list.get(i);
            }
        }
        return sum / (list.size() - indexes.size());
    }

    public static void backtrack(List<Integer> list, int start, HashSet<Integer> indexes) {
        for (int i = start; i < list.size(); i++) {
            indexes.add(i);
            if (avg(list, indexes) == avg_e(list, indexes)) {
                System.out.println("Solution found!");
                printSolution(list, indexes);
            }
            backtrack(list, i + 1, indexes);
            indexes.remove(i);
        }
    }

    public static void main(String[] args) {
    	int [] A = {1, 9, 2, 8, 3, 7};
    	
    	List<Integer> intList = new ArrayList<Integer>();
        for (int index = 0; index < A.length; index++)
        {
            intList.add(A[index]);
        }
        

        backtrack(intList, 0, new HashSet<Integer>());
    }
}