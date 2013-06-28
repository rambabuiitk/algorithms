import java.util.Arrays;
import java.util.Comparator;


public class GridShortestDistance {
	public static void main(String[] args) {
		POS poses[] = { new POS(1,2),new POS(4,2),new POS(6,8),new POS(10,32),
				new POS(45,3),new POS(22,56),new POS(34,43),new POS(22,12),
				new POS(13,33),new POS(54,1),new POS(64,77)};
		POS ps = FindMeetingPlace(poses, poses.length);
		
		System.out.println("Meeting place ("+ps.x+","+ps.y+")");

	}
	static POS FindMeetingPlace(POS a[], int n)
	{
		POS pos = new POS(0,0);
		Arrays.sort(a,new CompX());
		pos.x = a[a.length/2].x;
		Arrays.sort(a,new CompY());
		pos.y = a[a.length/2].y;

		return pos;
	}
}

class CompX implements Comparator<POS> {
	public int compare(POS a, POS b)
	{
		return ((Integer)a.x).compareTo((Integer)b.x);
	}
}
class CompY implements Comparator<POS> {
	public int compare(POS a, POS b)
	{
		return ((Integer)a.y).compareTo((Integer)b.y);
	}
}

class POS
{
	int x;
	int y;	
	public POS(int a,int b)
	{
		x = a;
		y = b;
	}
}
