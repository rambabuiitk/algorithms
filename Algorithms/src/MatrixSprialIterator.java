import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MatrixSprialIterator<T> implements Iterator<T> {
	
	private int currentPosition;
	private List<T> list;
	
	public MatrixSprialIterator(T[][] a,int row,int column)
	{
		int x1 = 0;int y1=0;int x2=row;int y2=column;
		list = new ArrayList<T>() ;
		
		while (x1 < x2 && y1 < y2)
	    {
	        for (int i = y1; i < y2; ++i)
	        {
	        	list.add(a[x1][i]);
	        }
	        x1++;
	 
	        for (int i = x1; i < x2; ++i)
	        {
	        	list.add(a[i][y2-1]);
	        }
	        y2--;
	 
	        if ( x1 < x2)
	        {
	            for (int i = y2-1; i >= y1; --i)
	            {
	            	list.add(a[x2-1][i]);
	            }
	            x2--;
	        }
	 
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
	
	@Override
	public boolean hasNext()
	{
		return currentPosition < list.size();
	}
	
	@Override
	public T next()
	{
		T val = list.get(currentPosition);
		currentPosition = currentPosition + 1;
		return val;
	}
	
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
				
		Iterator<Integer> itr = new MatrixSprialIterator<Integer>(a, 5, 4);
		while(itr.hasNext())
		{
			System.out.print(itr.next()+" ");
		}
		
		Iterator<Character> itr1 = new MatrixSprialIterator<Character>(c, 6, 2);
		while(itr1.hasNext())
		{
			System.out.print(itr1.next()+" ");
		}
				
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
}
