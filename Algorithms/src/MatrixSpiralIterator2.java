import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixSpiralIterator2<T> implements Iterator<T> {
	
	// Enum for 4 different directions
	public enum DIRECTION {
		RIGHT, DOWN, LEFT, UP;
	};

	private int x, y;  // current x, y position while iterating
	private int r, c;  // row length and column length
	int count;

	private T[][] matrix;

	int max;
	DIRECTION d;

	/*
	 * Constructor to initialize the variables and check the boundary conditions
	 */
	public MatrixSpiralIterator2(T[][] a) throws NullPointerException,IllegalArgumentException{
		if(a == null)
		{
			throw new NullPointerException("Matrix is null. Cannot create Iterator");
		}
		
		if(a.length == 0)
		{
			throw new IllegalArgumentException("Matrix is empty.");
		}
		int colLength = a.length;
		int rowLength = a[0].length;
		for(int i=1;i<colLength;i++)
		{
			if(a[i].length != rowLength)
				throw new IllegalArgumentException("Rows of Different Length");
		}
		x = 0;
		y = 0;
		r = a.length;
		c = a[0].length;
		count = 0;
		matrix = a;
		d = DIRECTION.RIGHT;

	}

	/*
	 * This method returns true if it is possible to iterate to next possible postion
	 * Otherwise it return false
	 */
	@Override
	public boolean hasNext() {
		if (r == 0 || c == 0)
			return false;

		return true;
	}

	/**
	 * This method returns the next element based on the current x, y position.
	 * if it has already reached the end, it throws NoSuchElementException
	 */
	@Override
	public T next() throws NoSuchElementException {
		if (r == 0 || c == 0) {
			throw new NoSuchElementException("No Element Found");
		} else {
			T val = null;
			val = matrix[x][y];
			count++;
			computerNewPos();
			return val;
		}
	}

	/**
	 * This method computes the next position of x,y based on the direction
	 * if it reaches the end in that direction, it changes the direction to next
	 * possible direction and sets the x,y r,c value accordingly.
	 */
	private void computerNewPos() {
		switch (d) {
		case RIGHT:
			if (count == c) {
				d = DIRECTION.DOWN;
				count = 0;
				r = r - 1;
				x = x + 1;
			} else {
				y++;
			}
			break;
		case DOWN:
			if (count == r) {
				d = DIRECTION.LEFT;
				count = 0;
				c = c - 1;
				y = y - 1;
			} else {
				x++;
			}
			break;
		case LEFT:
			if (count == c) {
				d = DIRECTION.UP;
				count = 0;
				r = r - 1;
				x = x - 1;
			} else {
				y--;
			}
			break;
		case UP:
			if (count == r) {
				d = DIRECTION.RIGHT;
				count = 0;
				c = c - 1;
				y = y + 1;
			} else {
				x = x - 1;
			}
			break;
		}
	}

	/**
	 * remove method is not supported
	 */
	@Override
	public void remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException(
				"Remove Operation is not supported");
	}

	/*
	 * Driver for running the program.
	 */
	public static void main(String[] args) {
		Integer a[][] = { { 1, 2, 3, 4 }, 
				          { 14, 15, 16, 5 }, 
				          { 13, 20, 17, 6 },
				          { 12, 19, 18, 7 }, 
				          { 11, 10, 9, 8 } 
				         };

		Iterator<Integer> itr = new MatrixSpiralIterator2<Integer>(a);
		while (itr.hasNext()) {
			Integer val = itr.next();
			System.out.print(val + " ");
		}
		System.out.println();
		
		Character c[][] = { { 'a', 'b' }, 
				            { 'c', 'd' }, 
				            { 'e', 'f' },
				            { 'g', 'h' }, 
				            { 'i', 'j' },
				            { 'k', 'l' } 
				          };

		Iterator<Character> itr1 = new MatrixSpiralIterator2<Character>(c);
		while (itr1.hasNext()) {
			Character ch = itr1.next();
			System.out.print(ch + " ");
		}
	}
}
