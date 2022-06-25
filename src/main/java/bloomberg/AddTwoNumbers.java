package bloomberg;

import fastslow.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverseL1 = reverseNode(l1);
        ListNode reverseL2 = reverseNode(l2);
        ListNode dummy = null;
        int carry =0;
        while(reverseL1!=null || reverseL2!=null){
            int x = (reverseL1==null)?0:reverseL1.value;
            int y = (reverseL2==null)?0:reverseL2.value;
            int sum = x +y + carry;
            carry = sum/10;
            ListNode curr = new ListNode(sum%10);
            curr.next = dummy;
            dummy = curr;
            if(reverseL1!=null) reverseL1 = reverseL1.next;
            if(reverseL2!=null) reverseL2 = reverseL2.next;
        }
        if(carry>0){
            ListNode curr = new ListNode(carry);
            curr.next = dummy;
            dummy = curr;
        }
        return dummy;
    }
    private ListNode reverseNode(ListNode li){
        ListNode prev= null;
        while(li!=null){
            ListNode next = li.next;
            li.next = prev;
            prev = li;
            li = next;
        }
        return prev;
    }
    public static void main(String...args){
        ListNode head = new ListNode(7);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.addTwoNumbers(head,head2);

    }
}
