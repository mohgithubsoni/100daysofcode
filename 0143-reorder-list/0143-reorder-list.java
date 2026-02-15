
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)return;

        /*To find middle of list*/
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        /*to reverse second half*/
        ListNode half = slow.next;
        slow.next = null;

        ListNode prev = null;
        while(half!=null){
            ListNode temp = half.next;
            half.next = prev;
            prev= half;
            half=temp;
        }

        /*to merge both list*/
        ListNode l1= head;
        ListNode l2 = prev;

        while(l2!=null){
            ListNode t1= l1.next;
            ListNode t2= l2.next;

            l1.next= l2;
            l2.next = t1;

            l1=t1;
            l2=t2;
        }
    }
}