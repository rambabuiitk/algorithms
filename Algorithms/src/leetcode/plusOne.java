// Given a number represented as an array of digits, plus one to the number.
public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = digits.length;
        int[] res = new int[len+1];
        int i;
        for (i=0; i<len; i++) {
            res[i] = digits[len - i-1];
        }
        res[i] = 0;
        
        int carry = 0;
        i = 1;
        carry = (res[0] + 1) /10;
        res[0] = (res[0] + 1) % 10;

        while (carry > 0) {
            
            int digit = res[i] + carry ;
            res[i] = digit % 10;
            carry =  digit /10;
            i++;
        }
        
        int end = len;
        if (res[len] == 1)
            end = len+1;
            
        int[] total = new int[end];
        for (i=0; i< end; i++) {
            total[i] = res[end-1-i];
        }
        return total;
    }
}
