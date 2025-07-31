
/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

 class Solution {
    public ListNode createLinkedList() {
        // Create nodes from last to first and link them
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        return head;
    }

     public ListNode reverseKGroup(ListNode head, int k){

        ListNode dummy = head;
        ListNode ans = reverseNodes(head, head.next, k);
        return ans ;


     }
     public ListNode reverseNodes(ListNode prev, ListNode start , int k){
        if (k<=1){
            return prev;
        }
        ListNode next = start.next;
        start.next=prev;
        prev = start ;
        start = next;

        return reverseNodes(prev, start , k-1);

     }

}







public class Main {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        ListNode head = s1.createLinkedList();
        ListNode ans = s1.reverseKGroup(head, 4);
        printLinkedList(ans);
        System.out.println("Hello, World!");
    }
    public static ListNode printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println(); // New line after printing
        return head; // Return the head (unchanged)
    }
}