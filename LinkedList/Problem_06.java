package LinkedList;

// Merge two sorted LinkedList
public class Problem_06 {
    public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		// LinkedListNode<Integer> res = new LinkedListNode<>(0);
        // LinkedListNode<Integer> r = res;
        // LinkedListNode<Integer> f = first;
        // LinkedListNode<Integer> s = second;
        // while(f != null && s != null){
        //     if(f.data <= s.data){
        //         res.next = new LinkedListNode<>(f.data);
        //         f = f.next;
        //     }
        //     else{
        //         res.next = new LinkedListNode<>(s.data);
        //         s = s.next;
        //     }
        //     res = res.next;
        // }
        // while(f != null){
        //     res.next = new LinkedListNode<>(f.data);
        //     f = f.next;
        //     res = res.next;
        // }
        // while(s != null){
        //     res.next = new LinkedListNode<>(s.data);
        //     s = s.next;
        //     res = res.next;
        // }
        // return r.next;

        LinkedListNode<Integer> l1 = first;
        LinkedListNode<Integer> l2 = second;
        LinkedListNode<Integer> res;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.data > l2.data){
            LinkedListNode<Integer> temp = l1;
            l1 = l2;
            l2 = temp;
        }
        res = l1;
        while(l1 != null && l2 != null){
            LinkedListNode<Integer> temp = null;
            while(l1 != null && l1.data <= l2.data){
                temp = l1;
                l1 = l1.next;
            }
            temp.next = l2;
            LinkedListNode<Integer> inter = l1;
            l1 = l2;
            l2 = inter;
        }
        return res;

	}
}
