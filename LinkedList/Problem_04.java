package LinkedList;
 class LinkedListNode {
        int data;
        LinkedListNode next;
        
        public LinkedListNode(int data) {
            this.data = data;
        }
    }

// Add two numbers
public class Problem_04 {
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode h1 = head1, h2 = head2;
        LinkedListNode res = new LinkedListNode(0);
        LinkedListNode dummy = res;
        int carryover = 0;
        int h1Data = 0, h2Data = 0;
        while(h1 != null || h2 != null || carryover == 1){
            h1Data = (h1 == null) ? 0 : h1.data;
            h2Data = (h2 == null) ? 0 : h2.data;
            int sum = h1Data + h2Data+ carryover;
            carryover = sum / 10;
            res.next = new LinkedListNode(sum % 10);
            res = res.next;
            if(h1 != null)
                h1 = h1.next;
            if(h2 != null)
                h2 = h2.next;
        }
        return dummy.next;
    }
}
