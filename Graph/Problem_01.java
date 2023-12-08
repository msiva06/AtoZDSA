package Graph;

// Counting Graphs
public class Problem_01 {
    public static int countingGraphs(int N) {
        int edges = N * (N-1) / 2;
        int ans = 0;
        ans = 1 << edges;
        return ans;
    }
}
