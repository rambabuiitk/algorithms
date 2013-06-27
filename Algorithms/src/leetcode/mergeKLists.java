// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;
public class Solution {
     class MyComparator implements Comparator<Item>
     {
        @Override
        public int compare(Item x, Item y)
        {
            if (x.node.val < y.node.val)
                return -1;
            else if (x.node.val > y.node.val)
                return 1;
            return 0;
        }
    }
    
    class Item{
        ListNode node;
        int index;
        public Item(ListNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (lists.size() < 1)
            return null;
        Comparator<Item> comparator = new MyComparator();
        PriorityQueue<Item> queue = 
            new PriorityQueue<Item>(lists.size(), comparator);
        for (int i=0; i<lists.size(); i++) {
            if (lists.get(i) != null)
            queue.add(new Item(lists.get(i), i));
        }
        
        ListNode res = new ListNode(0);
        ListNode head = null;
        if (queue.size() > 0)
            head = queue.peek().node;
        
        while (queue.size() != 0) {
            Item item = queue.poll();
            ListNode nextNode = lists.get(item.index).next;
            if ( nextNode != null) {
                queue.add(new Item(nextNode, item.index));
                lists.set(item.index, nextNode);
            }
            res.next = item.node;
            res = res.next;
        }
        return head;
    }
}
