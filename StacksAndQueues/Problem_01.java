package StacksAndQueues;

// Stack Implementation using arrays
public class Problem_01 {
        int[] arr;
        int capacity;
        int top;
        Problem_01(int capacity) {
           this.arr = new int[capacity];
           this.capacity = capacity;
           top = -1;
        }
        public void push(int num) {
            if(isFull() == 1)
                return;
            top+=1;
            arr[top] = num;
        }
        public int pop() {
            if(isEmpty() == 1)
                return -1;
            int num = arr[top];
            top -= 1;
            return num;
        }
        public int top() {
            if(top != -1)
                return arr[top];
            return -1;
        }
        public int isEmpty() {
            return top == -1 ? 1 : 0;
        }
        public int isFull() {
            return top == this.capacity-1 ?  1 : 0;
        }
}
