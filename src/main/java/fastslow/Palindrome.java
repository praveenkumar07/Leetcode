package fastslow;

public class Palindrome{
        public static boolean isPalindrome(ListNode head) {
            ListNode fast = head ,slow =head;
            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode prev = null;
            while(slow!=null){
                ListNode nxt = slow.next;
                slow.next = prev;
                prev = slow;
                slow = nxt;
            }
            fast = head;
            while(prev!=null){
                if(fast.value!=prev.value)
                    return false;
                fast= fast.next;
                prev = prev.next;
            }
            return true;
        }

        public static void main(String[] args) {
            ListNode head = new ListNode(2);
            head.next = new ListNode(4);
            head.next.next = new ListNode(6);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(2);
            System.out.println("Is palindrome: " + Palindrome.isPalindrome(head));
            head.next.next.next.next.next = new ListNode(2);
            System.out.println("Is palindrome: " + Palindrome.isPalindrome(head));
        }
}
