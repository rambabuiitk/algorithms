import java.util.Iterator;
import java.util.NoSuchElementException;

import junit.framework.TestCase;

import org.junit.Test;


public class MatrixSpiralIteratorTest extends TestCase {

	@Test
	public void testNullCondition() {
		try{
			Iterator<Integer> itr = new MatrixSpiralIterator2<Integer>(null);
		}catch(NullPointerException e)
		{
			System.out.println("Exception "+e.getMessage());
			assertTrue(true);
			return;
		}
		
		assertTrue(false);
	}
	
	@Test
	public void testEmptyCondition() {
		Integer[][] a ={};
		try{
			Iterator<Integer> itr = new MatrixSpiralIterator2<Integer>(a);
		}catch(IllegalArgumentException e)
		{
			System.out.println("Exception "+e.getMessage());
			assertTrue(true);
			return;
		}
		assertTrue(false);
	}
	
	@Test
	public void testUnEvenRows() {
		Integer[][] a ={{1,2},
						 {3,4,5}
					   };
		try{
			Iterator<Integer> itr = new MatrixSpiralIterator2<Integer>(a);
		}catch(IllegalArgumentException e)
		{
			System.out.println("Exception "+e.getMessage());
			assertTrue(true);
			return;
		}
		assertTrue(false);
	}
	
	@Test
	public void testSquare() {
		Integer[][] a ={
						 {1,2,3,4},
				 		 {12,13,14,5},
				 		 {11,16,15,6},
				 		 {10,9,8,7}		
			            };
		String expectedOutput = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 ";
		Iterator<Integer> itr = new MatrixSprialIterator<Integer>(a);
		StringBuilder str = new StringBuilder();
		while(itr.hasNext())
		{
			str.append(itr.next()+" ");
		}
		
		assertEquals(expectedOutput, str.toString());
	}
	
	@Test
	public void testRectangle() {
		Integer a[][] = { { 1, 2, 3, 4 }, 
				          { 14, 15, 16, 5 }, 
				          { 13, 20, 17, 6 },
				          { 12, 19, 18, 7 }, 
				          { 11, 10, 9, 8 } 
				        };
		String expectedOutput = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 ";
		Iterator<Integer> itr = new MatrixSprialIterator<Integer>(a);
		StringBuilder str = new StringBuilder();
		while(itr.hasNext())
		{
			str.append(itr.next()+" ");
		}
		assertEquals(expectedOutput, str.toString());
	}
	
	@Test
	public void testSingleColumn() {
		Integer a[][] = { { 1 }, 
				          { 2 }, 
				          { 3 },
				          { 4 }
		         		};
		String expectedOutput = "1 2 3 4 ";
		Iterator<Integer> itr = new MatrixSprialIterator<Integer>(a);
		StringBuilder str = new StringBuilder();
		while(itr.hasNext())
		{
			str.append(itr.next()+" ");
		}
		assertEquals(expectedOutput, str.toString());
	}
	
	@Test
	public void testSingleRow() {
		Integer a[][] = { { 1,2,3,4 }
       					};
			String expectedOutput = "1 2 3 4 ";
			Iterator<Integer> itr = new MatrixSprialIterator<Integer>(a);
			StringBuilder str = new StringBuilder();
			while(itr.hasNext())
			{
				str.append(itr.next()+" ");
			}
			assertEquals(expectedOutput, str.toString());
	}
	
	@Test
	public void testCharacter() {
			Character c[][] = { { 'a', 'b' }, 
		            { 'c', 'd' }, 
		            { 'e', 'f' },
		            { 'g', 'h' }, 
		            { 'i', 'j' },
		            { 'k', 'l' } 
		          };
			String expectedOutput = "a b d f h j l k i g e c ";
			StringBuilder str = new StringBuilder();
			Iterator<Character> itr1 = new MatrixSpiralIterator2<Character>(c);
			while (itr1.hasNext()) {
				Character ch = itr1.next();
				str.append(ch + " ");
			}
			assertEquals(expectedOutput, str.toString());
	}
	
	@Test
	public void testNoSuchElement() {
		Integer a[][] = { { 1,2,3,4 }
						};
		Iterator<Integer> itr = new MatrixSpiralIterator2<Integer>(a);
		while(itr.hasNext())
		{
			itr.next();
		}
		try
		{
			itr.next();
		}catch(NoSuchElementException e)
		{
			System.out.println("Exception "+e.getMessage());
			assertTrue(true);
			return;
		}
		assertTrue(false);
	}
	

}
