/*
 * 876. Middle of the Linked List
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node
Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 */


// Approach Two Pointer.
 // TC: O(n/2)
 // SC: O(1)
 class Solution {
    public ListNode middleNode(ListNode head) {
         ListNode slowPtr = head;
    ListNode fastPtr = head;

    // Travel until the fast pointer reaches
    // the last node or null
    while (fastPtr != null && fastPtr.next!= null) {

      // Slow pointer moves 1 node
      slowPtr = slowPtr.next;

      // Fast pointer moves 2 nodes
      fastPtr = fastPtr.next.next;
    }

    return slowPtr;
    }
}