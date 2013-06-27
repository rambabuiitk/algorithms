public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x < 1)
            return 0;
        if (x == 1)
            return 1;
            
        int root = 1;
        int mid = x/2;
        
        while (mid * mid > x || mid > 46340) {
            mid = (mid + x/mid)/2;
        }
        return mid;
    }
}
