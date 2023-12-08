package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// BFS 
public class Problem_04 {
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj){
        int[] visited = new int[n]; 
        List<Integer> res = new ArrayList<>();
        bfs(0,adj,visited,res);
        return res;
    }

    public static void bfs(int nod,List<List<Integer>> adj,int[] visited,List<Integer> res){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(nod);
        while(!queue.isEmpty()){
            Integer node = queue.poll();
            if(visited[node] == 1)
                continue;
            visited[node] = 1;
            res.add(node);
            List<Integer> adjL = adj.get(node);
            for(Integer n1 : adjL){
                if(visited[n1] == 0){
                    queue.offer(n1);
                }
            }
        }
    }
}
