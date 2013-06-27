import java.util.LinkedList;
import java.util.Queue;

public class MinQueue {

	Queue<Integer> q = new LinkedList<Integer>();
	Queue<Integer> minq1 = new LinkedList<Integer>();
	Queue<Integer> minq2 = new LinkedList<Integer>();
	boolean isMinq1Current = true;

	public void push(int a) {
		q.offer(a);
		if (isMinq1Current) {
			if (minq1.isEmpty())
				minq1.offer(a);
			else {
				while (!minq1.isEmpty() && minq1.peek() <= a)
					minq2.offer(minq1.poll());
				minq2.offer(a);
				while (!minq1.isEmpty())
					minq1.poll();
				isMinq1Current = false;
			}
		} else {
			if (minq2.isEmpty())
				minq2.offer(a);
			else {
				while (!minq2.isEmpty() && minq2.peek() <= a)
					minq1.offer(minq2.poll());
				minq1.offer(a);
				while (!minq2.isEmpty())
					minq2.poll();
				isMinq1Current = true;
			}
		}
	}

	public int pop() {
		int a = q.poll();
		if (isMinq1Current) {
			if (a == minq1.peek())
				minq1.poll();
		} else {
			if (a == minq2.peek())
				minq2.poll();
		}
		return a;
	}

	public int min() {

		if (isMinq1Current) {
			return minq1.peek();
		} else {
			return minq2.peek();
		}
	}

}
