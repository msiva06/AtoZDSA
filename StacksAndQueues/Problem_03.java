package StacksAndQueues;

// Implementation of queue using arrays
public class Problem_03 {
        int front, rear;
        int []arr;

        Problem_03() {
            front = 0;
            rear = 0;
            arr = new int[100001];
        }

        // Enqueue (add) element 'e' at the end of the queue.
        public void enqueue(int e) {
            
            arr[rear] = e;
            rear += 1;
            
        }

        // Dequeue (retrieve) the element from the front of the queue.
        public int dequeue() {
            if(front == rear)
                return -1;
            int elem = arr[front];
            front += 1;
            return elem;
        }
    
}
