package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Distance Of Nearest Cell Having 1 In A Binary Matrix
public class Problem_11 {
    public static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat, int n, int m) {
		ArrayList<ArrayList<Integer>> dist = new ArrayList<>();
		ArrayList<ArrayList<Integer>> visited = new ArrayList<>();
		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0; i < mat.size(); i++){
			ArrayList<Integer> temp = new ArrayList<>();
			ArrayList<Integer> v = new ArrayList<>();
			for(int j = 0; j < mat.get(i).size(); j++){
				if(mat.get(i).get(j) == 1){
					queue.offer(new int[]{i,j,0});
					v.add(1);
				}
				else{
					v.add(0);
				}
				temp.add(0);
			}
			dist.add(temp);
			visited.add(v);
		}
		while(!queue.isEmpty()){
			int[] popped = queue.poll();
			int x = popped[0];
			int y = popped[1];
			int distance = popped[2];	
			dist.get(x).set(y,distance);
			int[][]  offset = {{0,-1},{0,1},{1,0},{-1,0}};
			for(int[] off : offset){
				int row = x + off[0];
				int col = y + off[1];
				if(row >= 0 && col >= 0 && row < mat.size() && col < mat.get(0).size()  && visited.get(row).get(col) == 0){
					visited.get(row).set(col,1);
					queue.offer(new int[]{row,col,distance+1});
				}
			}
		}
		return dist;
	}
}
