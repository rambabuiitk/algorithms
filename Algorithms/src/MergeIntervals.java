import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	public class Interval {
		public int start;
		public int end;

		public Interval(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}

	public class MyComparatorA implements Comparator {
		public int compare(Object o1, Object o2) {
			Interval i1 = (Interval) o1;
			Interval i2 = (Interval) o2;
			return i1.start - i2.start;
		}
	}
	
	public class MyComparatorB implements Comparator {
		public int compare(Object o1, Object o2) {
			Interval i1 = (Interval) o1;
			Interval i2 = (Interval) o2;
			return i1.end - i2.end;
		}
	}
	

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if (intervals == null)
			return null;
		ArrayList<Interval> result = new ArrayList<Interval>();
		if (intervals.size() == 0)
			return result;
		if (intervals.size() == 1) {
			result.addAll(intervals);
			return result;
		}
		Collections.sort(intervals, new MyComparatorA());
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (int i = 1; i < intervals.size(); ++i) {
			Interval curr = intervals.get(i);
			if (curr.start <= end) {
				end = Math.max(end, curr.end);
			} else {
				result.add(new Interval(start, end));
				start = curr.start;
				end = curr.end;
			}
		}
		result.add(new Interval(start, end));
		return result;
	}

	public static int getMaxintersection(Interval[] intervals) {
		int result = 0;
		int[] count;
		int min = Integer.MAX_VALUE;
		int max = Integer.MAX_VALUE + 1;

		// get min and max of the intervals
		for (Interval i : intervals) {
			if (i.start < min)
				min = i.start;
			if (i.end > max)
				max = i.end;
		}

		if (min > max)
			throw new IllegalArgumentException();

		count = new int[max - min + 1];

		for (Interval i : intervals)
			for (int j = i.start - min; j <= i.end - min; j++)
				count[j]++;

		for (int i = 0; i < count.length; i++)
			if (result < count[i])
				result = count[i];

		return result;
	}
	
	public int getPoint(ArrayList<Interval> intervals) {
	    // validation
	    if (intervals == null || intervals.size() == 0) {
	        return 0;
	    }
	    List<Interval> listA = new ArrayList(intervals);
	    List<Interval> listB = new ArrayList(intervals);
	    Collections.sort(listA, new MyComparatorA());
	    Collections.sort(listB, new MyComparatorB());
	    int max = 0;
	    int maxPoint = listB.get(0).end;
	    for (int i = 0; i < listB.size(); i++) {
	        Interval interval = listB.get(i);
	        // find B in sortA. ( use binary search)
	        int index = search(listA, interval.end);
	        int count = index - i + 1;
	        if (count > max) {
	            max = count;
	            maxPoint = listB.get(i).end;
	        }
	    }
	    return maxPoint;
	}
}
