/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 /* Question: Given the head of a singly linked list, reverse the list, and return the reversed list.
Example 1:
 Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
  
Example 2:
Input: head = []
Output: []

  */

 // Approach : Recursion 
 // TC : O(N)
 // SC: O(N)
 class Solution {
    ListNode tail = null;
    public ListNode reverseList(ListNode head) {
         if(head == null ) return null;
         head = helper(head);
         head.next = null;
         return tail;

    }

        public ListNode helper(ListNode head) {
            if (head.next == null) {
                tail = head;
                return head;

            }
            ListNode revSmallAns = helper(head.next);
            revSmallAns.next = head;
            return  head;
        }
    }

