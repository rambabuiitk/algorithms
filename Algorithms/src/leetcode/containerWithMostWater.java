// runtime error
/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.

*/
public class Solution {
    class StackItem
    {
    int value;
    int index;
    };
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i;
        int m = -1;
        int top = -1;
        int left = -1;
        int n = height.length;
        StackItem[] st = new StackItem[n];
        for(i=0; i<n; i++) {
            while(top >= 0 && (i==n || height[i] < st[top].value)) {
                if (top > 0)
                    left = st[top-1].index;
                else
                    left = -1;
                m = Math.max(m, (i - 1 - left)*(st[top].value));
                --top;
            }
            if (i < n) {
                ++top;
                st[top].value = height[i];
                st[top].index = i;
            }
        }
        return m;
    }
}
import java.util.Arrays;
public class Solution {

    public class Element implements Comparable<Element>{
        public int index;
        public int height;
        @Override
        public int compareTo(Element value) {
            // TODO Auto-generated method stub
            if(height < value.height) return 1;
            else return 0;
        }

    }
    //1 2 4 3 --> 4
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max_areas = 0;
        Element arr[] = new Element[height.length];
        for(int i=0;i<height.length;i++){
            arr[i] = new Element();
            arr[i].height = height[i];
            arr[i].index = i;
        }
        Arrays.sort(arr);
        int left=arr[0].index,right=arr[0].index;
        //System.out.println(arr[0].height + " " + arr[0].index + " " + left + " " + right);
        for(int i=1;i <arr.length;i++){
            //System.out.println(arr[i].height + " " + arr[i].index + " " + left + " " + right);
            if(arr[i].index > left) max_areas = Math.max(max_areas, arr[i].height*(arr[i].index - left));
            if(arr[i].index < right) max_areas = Math.max(max_areas, arr[i].height*(right - arr[i].index));
            left = Math.min(arr[i].index,left);
            right = Math.max(right, arr[i].index);
        }
        return max_areas;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution s = new Solution();
        /*int height[] = new int[4];
        height[0] = 1;height[1] = 2;
        height[2] = 4;height[3] = 3;*/
        /*int height[] = new int[2];
        height[0] = 1;height[1] = 1;*/
        // 0,0,2,3,4,5,6,7,8,8
        // 9,
        //0 0 2 3 0 5 0 7 0 0
        //2 0 0 1 0 1 0 2 1 0
        //int height[] = {10,14,10,4,10,2,6,1,6,12};
        int height[] = {12,6,1,6,2,10,4,10,14,10};
        int max_areas = s.maxArea(height);
        System.out.println(max_areas);
    }

}
