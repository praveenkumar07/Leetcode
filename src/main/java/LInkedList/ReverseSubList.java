package LInkedList;

public class ReverseSubList {
    public static ListNode reverse(ListNode head, int p, int q) {
        ListNode previous = null;
        ListNode curr = head;
        // move until first given node and curr will be curr next and prev will be previous value
        for(int i=0;curr!=null && i<p-1;i++){
            previous = curr;
            curr = curr.next;
        }
        //reverse the nodes from p to q
        ListNode currentTillNow = curr;  // hold the value of curr
        ListNode reversed = null;
        for(int i=p;curr!=null && i<=q;i++){
            ListNode next = curr.next;
            curr.next = reversed;
            reversed = curr;
            curr = next;
        }
        if(previous!=null){
            previous.next = reversed;
        }else{
            head = reversed;
        }
        currentTillNow.next = curr;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}