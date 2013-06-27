import java.util.Comparator;
import java.util.PriorityQueue;

// given a 2D NxN matrix where both rows and columns are sorted, find the kth largest element.

//Solution - Use a Priority Queue to do a DFS. O(k log K).

class Node {
    public int num;
    public int i;
    public int j;

    public Node(int a, int b, int c){
        this.num = a;
        this.i = b;
        this.j = c;
    }
}

public class PQProblem{
    
    public static int N = 4;

    public static int get_kth(int[][] Arr, PriorityQueue<Node> pq, int count, int k, boolean[][] bit){
            
        Node top = pq.peek();
        pq.remove();

        count++;
        
        if (count == k) return top.num;
        
        if (top.i+1 < N && !bit[top.i+1][top.j])
        {
            pq.offer(new Node(Arr[top.i+1][top.j], top.i+1,top.j));
            bit[top.i+1][top.j] = true;
        }
        
        if (top.j+1 < N && !bit[top.i][top.j+1])
        {
            pq.offer(new Node(Arr[top.i][top.j+1], top.i, top.j+1));
            bit[top.i][top.j+1] = true;
        }

        return get_kth(Arr,pq,count,k,bit);
    }

    public static void main(String[] args){
            
        int [][] Arr = {{1,5,10,12},
                 {3,8,11,13},
                 {7,9,14,16},
                 {20,21,22,23}};
        boolean[][] bit = new boolean[N][N];
        bit[0][0] = true;

        // get k-th element from the 2D Matrix.
        int k = 9;

        PriorityQueue<Node> pq = new PriorityQueue<Node>(k+1, 
                    new Comparator<Node>(){ 
                        public int compare(Node a, Node b)
                        { return a.num - b.num;
                        }
                    });        

        pq.offer(new Node(Arr[0][0],0,0));

        int res = get_kth(Arr,pq,0,k,bit);
        System.out.println(res);        
    }
}