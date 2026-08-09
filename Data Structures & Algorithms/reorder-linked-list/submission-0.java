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
    public void reorderList(ListNode head) {
        Stack<ListNode>st = new Stack<>();
        ListNode curr=head;
        int size=0;
        while(curr!=null){
            size++;
            st.push(curr);
            curr=curr.next;
        }
     // 2->4->6->8
     curr=head;
     for(int i=0;i<size/2;i++){
            ListNode element=st.peek();
            st.pop();
            element.next=curr.next;
            curr.next=element;
            curr=curr.next.next;
        }
        curr.next=null;
    }
}
