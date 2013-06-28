import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	public static List<Interval> mergedIntervals(List<Interval> intervals,
			Interval newInterval) {
		int startIndex = 0;
		for (int i = -1; i < intervals.size(); ++i) {
			Interval current = i == -1 ? null : intervals.get(i);
			Interval next = i + 1 == intervals.size() ? null : intervals
					.get(i + 1);
			if ((current == null || current.start <= newInterval.start)
					&& (next == null || newInterval.start <= next.start))
				startIndex = i + 1;
		}
		List<Interval> sol = new ArrayList<Interval>();
		sol.addAll(intervals);
		sol.add(startIndex, newInterval);

		int i = startIndex;
		// shrink to left
		for (; i - 1 >= 0;) {
			Interval current = sol.get(i);
			Interval previous = sol.get(i - 1);
			if (current.start <= previous.end) {
				current.start = current.start >= previous.start ? previous.start
						: current.start;
				current.end = current.end >= previous.end ? current.end
						: previous.end;
				sol.remove(i - 1);
				--i;
			} else {
				break;
			}
		}

		for (int j = i; j + 1 < sol.size();) {
			Interval current = sol.get(j);
			Interval next = sol.get(j + 1);
			if (current.end >= next.start) {
				current.start = current.start >= next.start ? next.start
						: current.start;
				current.end = current.end >= next.end ? current.end : next.end;
				sol.remove(j + 1);
			} else {
				break;
			}
		}

		return sol;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();

		intervals.add(new Interval(1, 5));
		intervals.add(new Interval(6, 15));
		intervals.add(new Interval(20, 21));
		intervals.add(new Interval(23, 26));
		intervals.add(new Interval(27, 30));
		intervals.add(new Interval(35, 40));

		Interval another = new Interval(14, 33);

		List<Interval> result = mergedIntervals(intervals, another);

		for (Interval res : result) {
			System.out.println(res.start + "," + res.end);
		}
	}
}

class Interval {
	public int start;
	public int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
