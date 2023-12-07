import java.util.Arrays;
import java.util.Stack;

// Maximal Rectangle
public class Problem_54 {
    public int maximalRectangle(char[][] matrix) {
        int cols = matrix[0].length;
        int rows = matrix.length;
        int[] heights = new int[cols];
        int maxi = Integer.MIN_VALUE;
        for(int row = 0; row< rows;row++){
          for(int col = 0; col < cols; col++){
            if(matrix[row][col] == '1')
              heights[col]++;
            else
              heights[col] = 0;
            
          }
          Arrays.stream(heights).forEach(System.out::println);
          int area = maximalArea(heights);
            //System.out.println(area);
            maxi = Math.max(maxi,area);
          
        }
        return maxi;
        
    }

    public int maximalArea(int[] heights){
       Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int length = heights.length;
        int area =Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++)
        {
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i])
            {
                int currHeight = heights[stack.pop()];
                int distance = i - stack.peek() -1;
                area = Math.max(area, currHeight * distance);
            }
            stack.push(i);
        }
        while(stack.peek() != -1)
        {
            int currHeight = heights[stack.pop()];
            int distance = length - stack.peek() -1;
            area = Math.max(area, currHeight * distance);
        }
        return area;
    }
}
