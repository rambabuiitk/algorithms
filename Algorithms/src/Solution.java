import java.util.Scanner;
public class Solution
{
	int NumberOfGuessesAllowed;
	int guessedNumbers;
	static int numberOfCases;
	int N;
	int K;
	int Q;
	static Scanner read;
	int[] guess;
	int[] answer;
	int guessscore;
	int ansscore;
	boolean compare;

	public static void main(String[] args)
	{
		Solution p = new Solution();

		//System.out.println("Enter a number from 1 to 100");
		read = new Scanner(System.in);
		int c = read.nextInt();
		numberOfCases = c;

		//System.out.println("Enter the first test case(n): (1<=n)");
		int n = read.nextInt();
		
		//System.out.println("Enter the second test case(k): (k<=11)");
		int k = read.nextInt();

		//System.out.println("Enter the third test case(q): (1<=q<=8)");
		int q = read.nextInt();
		
		for(int i =0; i<numberOfCases; i++)
		{
			p.validateTestCases(n, k, q);
			//System.out.println("Starting Number test " + (i+1) + "/" + numberOfCases + "...");
			p.vailidateGuesses();
			p.validateAnswers();
			p.compareGuessesAndAnswers();
			//System.out.println("");
		}				
	}	
	public void validateTestCases(int n, int k, int q)
	{
		if(1<=n && k<=11 && (1<=q && q<=8))	
		{
			//System.out.println("Test passed....");		
		}
		else
		{
			//System.out.println("You Values did not pass the validation test");
			//System.exit(0);
		}
		NumberOfGuessesAllowed = q;
		guessedNumbers = k;
		N = n;
		K = k;
		Q = q;
	}
	public void vailidateGuesses()
	{	
		guess = new int[guessedNumbers];

	
		{
			for(int i =0; i<guessedNumbers; i++)
			{
				//System.out.println("Enter No " + (i+1) + " guess");
				guess[i]= read.nextInt();
				if(guess[i]<1)
				{
					//System.out.println("You Values did not pass the validation test");
					//System.exit(0);
				}
			}
			
			read.nextInt();
			
		}
	}
	public void validateAnswers()
	{
		answer = new int[guessedNumbers];
		for(int i =0; i<guessedNumbers; i++)
		{
			//System.out.println("Enter No " + (i+1) + " answer");
			answer[i]= read.nextInt();
				if(answer[i]>guessedNumbers)
				{
					//System.out.println("You Values did not pass the validation test");
					//System.exit(0);
				}
		}
		
		read.nextInt();
	}
	public void compareGuessesAndAnswers()
	{
		for(int i =0; i<guessedNumbers; i++)
		{	
			
			if(compare=guess[i]==answer[i]==true)
			{
				break;
			}
	
		}
		System.out.println((compare?"Yes":"No"));
	}

}
	