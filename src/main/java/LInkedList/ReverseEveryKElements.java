package LInkedList;



class ReverseEveryKElements {

    public static ListNode reverse(ListNode head, int k) {
        ListNode curr = head;
        ListNode reversed = null;
        while(true){
            ListNode previous = reversed;
            ListNode currTillNow = curr;
            for(int i=0;curr!=null&& i<k;i++){
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
            currTillNow.next = curr;
            if(curr == null)
                break;
            reversed =currTillNow; // current now becomes the next previous
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryKElements.reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
