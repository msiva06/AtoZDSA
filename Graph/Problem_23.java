package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;



class Pair{
	int node;
	int distance;
	public Pair(int node,int distance){
		this.node = node;
		this.distance = distance;
	}
} 

// Djikstra's algorithm
public class Problem_23 {
    public static ArrayList < Integer > dijkstra(ArrayList< ArrayList < Integer > > vec, int vertices, int edges, int source){
		int[] dist = new int[vertices];
		Arrays.fill(dist,Integer.MAX_VALUE);
		PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);
		dist[source] = 0;
		pq.offer(new Pair(source,0));

		ArrayList<Pair>[] adjL = new ArrayList[vertices];
		for(int i = 0; i < vertices;i++){
			adjL[i] = new ArrayList<>();
		}

		for(int i = 0; i < edges; i++){
			int src = vec.get(i).get(0);
			int dest = vec.get(i).get(1);
			adjL[src].add(new Pair(dest,vec.get(i).get(2)));
			adjL[dest].add(new Pair(src,vec.get(i).get(2)));
		}

		while(!pq.isEmpty()){
			Pair p = pq.poll();
			int distance = p.distance;
			int node = p.node;
			ArrayList<Pair> adjP = adjL[node];
			for(Pair pr : adjP){
				if(distance + pr.distance < dist[pr.node]){
					
					dist[pr.node] = distance + pr.distance;
					pq.offer(new Pair(pr.node,dist[pr.node]));
					
				}
			} 
		}
		ArrayList<Integer> res = new ArrayList<>();
		for(int i = 0; i < vertices; i++){
			res.add(dist[i]);
		}
		return res;
	}
}
