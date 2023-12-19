package LinkedList;

class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
        LinkedListNode(T data)
        {
            this.data = data;
            this.next = null;
        }
    }

// Delete node in linkedlist
public class Problem_05 {
    public static void deleteNode(LinkedListNode<Integer> node) {
		node.data = node.next.data;
        node.next = node.next.next;
	}
}
