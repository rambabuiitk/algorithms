import java.util.Stack;


public class PairBSTSum {

	public static int[] findSum(int toSearch, Node root){
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        Node cur1 = root;
        Node cur2 = root;
        boolean done1 = false, done2 = false;

        int val1 = 0, val2 = 0;

        while (true) {
            while(!done1){
                if(cur1 != null){
                    s1.push(cur1);
                    cur1 = cur1.left;
                }
                else {
                    if(s1.isEmpty()) done1 = true;
                    else {
                        cur1 = s1.pop();
                        val1 = cur1.value;
                        cur1 = cur1.right;
                        done1 = true;
                    }
                }
            }
            while(!done2){
                if(cur2 != null){
                    s2.push(cur2);
                    cur2 = cur2.right;
                }
                else {
                    if(s2.isEmpty()) done2 = true;
                    else {
                        cur2 = s2.pop();
                        val2 = cur2.value;
                        cur2 = cur2.left;
                        done2 = true;
                    }
                }
            }
            if (val1 + val2 == toSearch){
                int[] res = {val1,val2};
                return res;
            }
            else if (val1 + val2 > toSearch){
                done2 = false;
            }
            else {
                done1 = false;
            }
        }
    }
}
	

