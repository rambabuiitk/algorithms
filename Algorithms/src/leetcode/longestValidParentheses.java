// Fail test cases
// "()(()" 4 2
// )()())()()( 8 4
//可以用stack 和 dp。不过我也是在有提示的情况下做出来的。我本来是hbase的思路。
//但是做不对。没想到你那个思路。你这么快能想到正确的解法还是挺赞的。

/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/
public class test {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.next();

        int[] dp=new int[str.length()];
        Arrays.fill(dp,-1);
        Stack<Integer> stack=new Stack<Integer>();
        int max=0;
        int maxcount=0;

        for(int i=0;i<str.length();i++) {
            char c=str.charAt(i);
            if(c=='(') {
                stack.add(i);
            } else {
                if(!stack.isEmpty()) {
                    int m=stack.pop();
                    if(m>0 && dp[m-1]!=-1)
                        dp[i]=Math.min(dp[m-1],m);
                    else
                        dp[i]=m;

                    int len=i-dp[i]+1;
                    if(len>max) {
                        max=len;
                        maxcount=1;
                    } else if(len==max)
                        maxcount++;
                }
            }
        }

        if(max>0)
            System.out.println(max+" "+maxcount);
        else
            System.out.println("0 1");
    }
}

/*
import java.util.*;
public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Character> st = new Stack<Character>();
        int no = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                st.push(c);
            
            if (c == ')' ) {
                if (!st.empty() && st.peek() == '(') {
                    no +=2 ;
                    st.pop();
                }
            }
        }
        return no;
    }
}
*/
