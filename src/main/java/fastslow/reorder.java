package fastslow;

public class reorder {
    public static void RearrangeList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = reverse(slow),temp;
        fast = head;
        while(reversed.next!=null){
            temp = fast.next;
            fast.next = reversed;
            fast = temp;

            temp = reversed.next;
            reversed.next = fast;
            reversed = temp;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        reorder.RearrangeList(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
    public static ListNode reverse(ListNode head){
        ListNode prev= null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
