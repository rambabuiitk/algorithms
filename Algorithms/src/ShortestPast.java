import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ShortestPast {

	public static void main(String[] args) {
		CGraph gph = new CGraph(5);
		gph.inputEdge(0, 2, 2);
		gph.inputEdge(2, 3, 10);
		gph.inputEdge(0, 3, 20);
		gph.inputEdge(0, 2, 2);
		gph.inputEdge(2, 1, 1);
		gph.inputEdge(0, 1, 5);
		gph.inputEdge(1, 3, 12);
		gph.inputEdge(1, 4, 2);
		gph.inputEdge(4, 3, 3);

		gph.PrintCheapestRout(2, 4);
	}

}

class CGraph
{
	int m_nNodes;
	int m_pGraph[][];
	
	CGraph(int n)
	{
		m_nNodes = n;
		m_pGraph = new int[n][n];
	}

	void inputEdge(int nIndex1, int nIndex2, int nCost)
	{
		if (nIndex1 < 0 || nIndex1 >= m_nNodes) return;
		if (nIndex2 < 0 || nIndex2 >= m_nNodes) return;
		if (nCost <= 0) return;

		m_pGraph[nIndex1][nIndex2] = nCost;
	}
	void PrintCheapestRout(int nIndex1, int nIndex2)
	{
		DIST_REC pRec[] = new DIST_REC[m_nNodes];
		for(int i = 0;i<m_nNodes;i++)
		{
			pRec[i] = new DIST_REC();
		}
		Deque<Integer> que = new LinkedList<Integer>();
		que.push(nIndex1);

		while (!que.isEmpty())
		{
			int nIndex = que.peek();
			que.pop();
			pRec[nIndex].bCalc = true;

			for (int i = 0; i < m_nNodes; i++)
			{
				if (i != nIndex && m_pGraph[nIndex][i] > 0)
				{
					que.push(i);
					if (pRec[i].nPrev == -1 || pRec[i].nCost > m_pGraph[nIndex][i] + pRec[nIndex].nCost)
					{
						pRec[i].nPrev = nIndex;
						pRec[i].nCost = m_pGraph[nIndex][i] + pRec[nIndex].nCost;
					}
				}
			}
		}

		if (pRec[nIndex2].nCost <= 0)
		{
			System.out.println("No path to destination");
		}
		else
		{
			System.out.println("Cost : "+pRec[nIndex2].nCost);
			Stack<Integer> stk = new Stack<Integer>();
			int nIter = nIndex2;
			while (nIter >= 0)
			{
				stk.push(nIter);
				nIter = pRec[nIter].nPrev;
			}

			while (!stk.empty())
			{
				int n = stk.peek();
				stk.pop();
			}
		}
	}

	private class DIST_REC 
	{
		int nCost;
		int nPrev;
		boolean bCalc;

		DIST_REC() { nCost = 0; nPrev = -1; bCalc = false; }
	};
	
};


