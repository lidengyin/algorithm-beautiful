package 题库.两数相加;


import org.xml.sax.ext.Locator2;

import java.util.List;

/**
 * 两数相加
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p=l1, q=l2, curr = head;
        int carry=0;
        while (p != null || q != null){
            int x = (p != null) ? p.val:0;
            int y = (q != null) ? q.val:0;
            int sum = x+y+carry;
            carry=sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            if (p != null) p=p.next;
            if (q != null) q=q.next;
        }
        if (carry > 0){
            curr.next=new ListNode(carry);
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1, l2;

    }
    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}