/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode cur = null;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                cur = head;
                while(cur != slow){
                    cur = cur.next;
                    slow = slow.next;
                }
                break;
            }
        }
        return cur;
    }
}