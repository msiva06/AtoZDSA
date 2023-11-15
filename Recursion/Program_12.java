// Reverse stack using recursion
public class Program_12 {
    public static void reverseStack(Stack<Integer> stack) {
		if(stack.isEmpty())
			return;
		Integer popped = stack.pop();
		reverseStack(stack);
		reverseInsert(stack,popped);
		
	}

	public static void reverseInsert(Stack<Integer> stack, Integer x){
		if(stack.isEmpty()){
			stack.push(x);
			return;
		}
		int temp = stack.pop();
		reverseInsert(stack,x);
		stack.push(temp);
		
	}
}
