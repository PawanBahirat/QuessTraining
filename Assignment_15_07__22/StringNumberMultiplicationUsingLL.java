import java.util.*;

class StringNumberMultiplicationUsingLL {
    public static Scanner scn = new Scanner(System.in);

    public static class Node {
        int val = 0;
        Node next = null;
        Node(){}
        Node(int val) { this.val = val; }
    }

    public static Node multiply(Node l1, Node l2) {
        Node result = new Node();
        Node head = result;
        int carry = 0;

        while(l1 != null && l2 != null){
            result.next = new Node((l1.val+l2.val+carry)%10);
            if(l1.val+l2.val+carry >= 10) carry = 1;
            else carry =0;
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l2 != null){
            result.next = new Node((l2.val + carry)%10);
            if(l2.val + carry >= 10) carry = 1;
            else carry = 0;
            result = result.next;
            l2 = l2.next;
        }
        while(l1 != null){
            result.next = new Node((l1.val +carry)%10);
            if(l1.val + carry >= 10) carry = 1;
            else carry = 0;
            result = result.next;
            l1 = l1.next;
        }
        if(carry == 1) result.next = new Node(carry);
        return head.next;
    }


    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static Node makeList(int n) {
        Node dummy = new Node(-1);
        Node prev = dummy;
        while (n-- > 0) {
            prev.next = new Node(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Node l1 = makeList(scn.nextInt());
        Node l2 = makeList(scn.nextInt());

        Node ans = multiply(l1, l2);
        printList(ans);
    }

}