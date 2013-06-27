import java.util.Iterator;


public class MatrixSpiralIterator2<T> implements Iterator<T> {

	public enum DIRECTION
	{
		RIGHT,DOWN,LEFT,UP;
	};
	
	private int x,y;
	private int r,c;
	int count;
	
	private T[][] matrix;

	int max;
	DIRECTION d;
	
	public MatrixSpiralIterator2(T[][] a,int row,int column)
	{
		x =0;
		y= 0;
		r = row;
		c = column;
		count = 0;
		matrix = a;
		d = DIRECTION.RIGHT;
		
	}
	
	
	@Override
	public boolean hasNext() {
		
		if(r == 0 || c == 0)
		 return false;
		
		return true;
	}

	@Override
	public T next() {
		
		T val = null;
		val = matrix[x][y];
		count++;
		computerNewPos();
		return val;
	}
	
	private void computerNewPos()
	{
		switch(d)
		{
			case RIGHT:
				if(count == c)
				{
					d = DIRECTION.DOWN;
					count=0;
					r = r-1;
					x = x+1;
				}else{
					y++;
				}
				break;
			case DOWN:
				if(count == r)
				{
					d = DIRECTION.LEFT;
					count = 0;
					c = c-1;
					y = y -1;
				}else
				{
					x++;
				}
				break;
			case LEFT:
				if(count == c)
				{
					d = DIRECTION.UP;
					count = 0;
					r = r-1;
					x = x-1;
				}else
				{
					y--;
				}
				break;
			case UP:
				if(count == r)
				{
					d = DIRECTION.RIGHT;
					count = 0;
					c = c-1;
					y = y+1;
				}else
				{
					x = x-1;
				}
				break;
		}
	}
	

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	
	public static void main(String[] args) {
		Integer a[][] = {
							{ 1, 2, 3, 4},
							{14, 15, 16, 5},
							{13, 20, 17, 6},
							{12, 19, 18, 7},
							{11, 10, 9, 8}
						};
		
		Iterator<Integer> itr = new MatrixSpiralIterator2<Integer>(a, 5, 4);
		while(itr.hasNext())
		{
			Integer val = itr.next();
			System.out.print(val+" ");
		}
		
		Character c[][] = { {'a', 'b'},
							{'c', 'd'},
							{'e', 'f'},
							{'g', 'h'},
							{'i', 'j'},
							{'k', 'l'}
						 };
		
		Iterator<Character> itr1 = new MatrixSpiralIterator2<Character>(c, 6, 2);
		while(itr1.hasNext())
		{
			Character ch = itr1.next();
			System.out.print(ch + " ");
		}

	}

}
