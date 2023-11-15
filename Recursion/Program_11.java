import java.util.List;
import java.util.Stack;

// Sort Stack
public class Program_11 {
    public static void sortStack(Stack<Integer> s){
        if(s.isEmpty())
            return;
        Integer popped = s.pop();
        sortStack(s);
        sortInsert(s,popped);
    }

    public static void sortInsert(Stack<Integer> s,Integer x){
        if(s.isEmpty() || s.peek() < x){
            s.push(x);
            return;
        }
        Integer temp = s.pop();
        sortInsert(s,x);
        s.push(temp);
    }

}
