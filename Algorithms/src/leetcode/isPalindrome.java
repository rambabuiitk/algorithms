public class Solution {

    boolean isPalindrome(int x) {
        if (x<0) return false;
        int div = 1;
        while (x/div >= 10) div *= 10;
        int l;
        int r;
        while ( x != 0) {
            l = x/div;
            r = x%10;
 
            if (l != r)
                return false;
           
           x = (x%div)/10;
           div /= 100;
        }
        return true;
    }

}
