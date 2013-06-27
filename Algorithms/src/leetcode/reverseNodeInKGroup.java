/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
*/
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
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        int count = 0;   
     
        while(current !=null && count++ <k) {
            current = current.next;
        }
        
        if (count < k)
            return head;
            
        count = 0;
        current = head;
        /*reverse first k nodes of the linked list */
        while (current != null && count < k) {
           next  = current.next;
           current.next = prev;
           prev = current;
           current = next;
           count++;
        }
        
        /* next is now a pointer to (k+1)th node
           Recursively call for the list starting from current.
           And make rest of the list as next of first node */
        if(next !=  null) {  
            head.next = reverseKGroup(next, k); 
        }
     
        /* prev is new head of the input list */
        return prev;
    }
}
