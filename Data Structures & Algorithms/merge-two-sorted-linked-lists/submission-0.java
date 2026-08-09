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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode a=list1,b=list2,dummy=new ListNode(-1);
        ListNode result=dummy;
        while(a!=null &&  b!=null){
            if(a.val<=b.val){
            dummy.next=new ListNode(a.val);
            a=a.next;
            }
            else{
                dummy.next=new ListNode(b.val);
                b=b.next;
            }
            dummy=dummy.next;
        }
        if(b==null) dummy.next=a;
        if(a==null) dummy.next=b;
        return result.next; 
    }
}