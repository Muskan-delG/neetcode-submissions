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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a=l1;
        ListNode b=l2;
        int carry=0;
        ListNode result=new ListNode(-1);
        ListNode dummy=result;
        while(a!=null || b!=null){
            int sum=carry;
            if(a!=null){
                sum+=a.val;
                a=a.next;
             }
             if(b!=null){
             sum+=b.val;
             b=b.next;
             }
             carry=sum/10;
             dummy.next=new ListNode(sum%10);
             dummy=dummy.next;
        }
        if(carry==1)
        dummy.next=new ListNode(1);
        return result.next;
    }
}