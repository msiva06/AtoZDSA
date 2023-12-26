package StacksAndQueues;

import java.util.Stack;

// Celebrity problem
public class Problem_13 {
    public static int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < n; i++){
			stack.push(i);
		}
		while(stack.size() > 1){
			int id1 = stack.pop();
			int id2 = stack.pop();
			if(Runner.knows(id1,id2))
				stack.push(id2);
			else
				stack.push(id1);
		}
		int celebrity = stack.peek();
		boolean knowsOne = false, knowbyAll = true;
		for(int i = 0; i < n; i++){
			if(i != celebrity && Runner.knows(celebrity,i)){
				knowsOne = true;
				break;
			}
		}
		for(int i = 0; i < n; i++){
			if(i!= celebrity && !Runner.knows(i,celebrity)){
				knowbyAll = false;
				break;
			}
		}
		if(knowsOne || !knowbyAll)
			return -1;
		return celebrity;
    }
}
