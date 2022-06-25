package LInkedList;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRight {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node dummy = new Node(0);
        Node result = dummy;
        while(!queue.isEmpty()){
            int size = queue.size();
            Node prev = null;
            while(size-->0){
                Node curr = queue.poll();
                if(prev!=null) {
                    prev.next = new Node(curr.val);
                }
                prev = new Node(curr.val);
                if(curr.left!=null)
                    queue.offer(curr.left);
                if(curr.right!=null)
                    queue.offer(curr.right);
            }
            prev.next = null;
            result.next = prev;
            result = result.next;
        }
        return dummy.next;
    }
    public static void main(String...args){
        PopulateNextRight populateNextRight = new PopulateNextRight();
        Node node =  new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right = new Node(3);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        populateNextRight.connect(node);
    }
}
class Node {
    int val;
    Node left;
    Node right;
    Node next;

    Node(int val){
        this.val = val;
    }
}
