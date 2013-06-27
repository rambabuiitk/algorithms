import java.util.Iterator;



public class MatrixSpiralIterator1<T> implements Iterator<T> {

	public enum DIRECTION
	{
		RIGHT,DOWN,LEFT,UP;
	};
	
	private int x1,y1,x2,y2;
	int left,top,bottom,right;
	private T[][] matrix;

	int max;
	int count;
	DIRECTION d;
	
	public MatrixSpiralIterator1(T[][] a,int row,int column)
	{
		x1=0;y1=0;x2=row;y2=column;
		left = 0;top =0;bottom = row;right= column;
		matrix = a;
		d = DIRECTION.RIGHT;
		max = row * column;
		count = 0;
	}
	
	
	@Override
	public boolean hasNext() {
		
		if(count < max)
	      return true;
		
		return false;
	}

	@Override
	public T next() {
		
		T val = null;
		switch(d)
		{
			case RIGHT:
				val = matrix[x1][y1];
				getTopRightNext();
				break;
			case DOWN:
				val = matrix[x1][y2-1];
				getRightBottomNext();
				break;
			case LEFT:
				val = matrix[x2-1][y2-1];
				getBottomLeftNext();
				break;
			case UP:
				val =  matrix[x2-1][y1];
				getLeftTopNext();
				break;
		}
		
		
		if(val != null)
			count++;
		
		return val;
	}
	

	
	private void getTopRightNext()
	{
		if(y1 < y2-1)
		{
			y1 = y1+1;
		}else
		{
			top = top+1;
			x1= top;
			y1 = left;
			d = DIRECTION.DOWN;
		}
	}
	
	private void getRightBottomNext()
	{
		 
		if(x1 < x2-1)
		{
			x1 = x1+1;
		}else
		{
			right = right -1;
			y2 = right;
			x1 = top;
			d = DIRECTION.LEFT;
		}
	}
	
	private void getBottomLeftNext()
	{
		if(y2-1 > y1)
		{
			y2 = y2-1;
		}else
		{
			bottom = bottom -1;
			x2 = bottom;
			y2 = right;
			d = DIRECTION.UP;
			
		}
	}
	
	private void getLeftTopNext()
	{
		if(x2-1 > x1)
		{
			x2 = x2-1;
		}
		else
		{
			left = left+1;
			y1 = left;
			x2 = bottom;
			d = DIRECTION.RIGHT;
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
		
		Iterator<Integer> itr = new MatrixSpiralIterator1<Integer>(a, 5, 4);
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
		
		Iterator<Character> itr1 = new MatrixSpiralIterator1<Character>(c, 6, 2);
		while(itr1.hasNext())
		{
			Character ch = itr1.next();
			System.out.print(ch + " ");
		}

	}

}
