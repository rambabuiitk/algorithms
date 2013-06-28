import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MatrixSprialIterator<T> implements Iterator<T> {
	
	private int currentPosition;
	private List<T> list;
	
	/*
	 * Constructor to initialize the variables and check the boundary conditions
	 * It copies all the elements of the matrix in spiral order to a list
	 */
	public MatrixSprialIterator(T[][] a) throws NullPointerException,IllegalArgumentException
	{
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
		int x1 = 0;int y1=0;int x2=a.length;int y2=a[0].length;
		list = new ArrayList<T>() ;
		
		while (x1 < x2 && y1 < y2)
	    {
			/* copy the first row to the list from the remaining rows */
	        for (int i = y1; i < y2; ++i)
	        {
	        	list.add(a[x1][i]);
	        }
	        x1++;
	 
	        /* copy the last column to the list from the remaining columns */
	        for (int i = x1; i < x2; ++i)
	        {
	        	list.add(a[i][y2-1]);
	        }
	        y2--;
	        
	        /* copy the last row to the list from the remaining rows */
	        if ( x1 < x2)
	        {
	            for (int i = y2-1; i >= y1; --i)
	            {
	            	list.add(a[x2-1][i]);
	            }
	            x2--;
	        }
	 
	        /* copy the first column to the list from the remaining columns */
	        if (y1 < y2)
	        {
	            for (int i = x2-1; i >= x1; --i)
	            {
	            	list.add(a[i][y1]);
	            }
	            y1++;    
	        }        
	    }
		
		currentPosition = 0;
	}
	
	/*
	 * This method returns true if current position is less than list size
	 * Otherwise it return false
	 */
	@Override
	public boolean hasNext()
	{
		return currentPosition < list.size();
	}
	
	/*
	 * This method returns the element at the current position and 
	 * increments the current position
	 * It throws a NoSuchElementException if the current position is greater than list size
	 */
	@Override
	public T next() throws NoSuchElementException
	{
		if(currentPosition < list.size())
		{
			T val = list.get(currentPosition);
			currentPosition = currentPosition + 1;
			return val;
		}else
		{
			throw new NoSuchElementException("No Element Found");
		}
	}
	
	/**
	 * remove method is not supported
	 */
	@Override
	public void remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Remove operation is not supported");
	}
	
	/*
	 * Driver for running the program.
	 */
	public static void main(String[] args)
	{
		Integer a[][] = {
							{ 1, 2, 3, 4},
							{14, 15, 16, 5},
							{13, 20, 17, 6},
							{12, 19, 18, 7},
							{11, 10, 9, 8}
						};
		
		Character c[][] = { {'a', 'b'},
							{'c', 'd'},
							{'e', 'f'},
							{'g', 'h'},
							{'i', 'j'},
							{'k', 'l'}
					};
				
		Iterator<Integer> itr = new MatrixSprialIterator<Integer>(a);
		while(itr.hasNext())
		{
			System.out.print(itr.next()+" ");
		}
		
		System.out.println();
		
		Iterator<Character> itr1 = new MatrixSprialIterator<Character>(c);
		while(itr1.hasNext())
		{
			System.out.print(itr1.next()+" ");
		}
				
	}
}
