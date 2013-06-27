// large data set says: overtime
/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/
public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String rStr = new StringBuffer(s).reverse().toString();
        int i = 0; 
        int j=0;
        int len = s.length();
        int maxLen = 0;
        int start = 0;
        int[][] d = new int[len+1][len+1];
        for ( i=1; i<=len; i++) {
            for( j=1; j<=len; j++) {
                if (s.charAt(i-1) == rStr.charAt(j-1)) {
                    d[i][j] = d[i-1][j-1]+1;
                    if (maxLen < d[i][j]) {
                        maxLen = d[i][j];
                        start = i - maxLen;
                    }  
                } else
                    d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
            }
        }
        
        return s.substring(start, start + maxLen);
    }
}
