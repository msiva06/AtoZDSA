package LinkedList;

// Delete Kth Node From End
public class Problem_03 {
    public static Node removeKthNode(Node head, int K)
    {
        Node res = head;
        Node slow = head;
        Node fast = head;
        while(K > 0){
            
            fast = fast.next;
            K--;
        }
        if(fast == null)
            return slow.next;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        if(slow != null && slow.next != null)
            slow.next = slow.next.next;
        return res;
    }
}
