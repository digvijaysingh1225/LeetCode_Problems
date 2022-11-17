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
class Solution {
    public ListNode swapPairs(ListNode head) {
//         if(head == null){
//             return null;
//         }
//         ListNode prevNode = new ListNode(0);
//         prevNode.next = head;
//         ListNode newHead = prevNode;
//         while(prevNode.next != null && prevNode.next.next != null){
//             ListNode n1 = prevNode.next;
//             ListNode n2 = n1.next;
//             ListNode nextNode = n2.next;
            
//             prevNode.next = n2;
//             n2.next = n1;
//             n1.next = nextNode;
            
//             prevNode = n1;
//         }
//         return newHead.next;
        
        
        
        if(head == null || head.next == null){
            return head;
        }
        ListNode p1 = head, p2 = head.next, p3 = p2.next;
        p1.next = p3;
        p2.next = p1;
        if(p3 != null){
            p1.next = swapPairs(p3);
        }
        return p2;
    }
}