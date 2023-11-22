import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC323NumberofConnectedComponentsinUndirectedGraph {
    // Link: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/
    //This program counts the number of connected components in an undirected graph given its number of vertices (n) and a set of edges (edges).

    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>()); //adjacency list is a list of lists, where each index corresponds to a vertex, and the inner //
            //lists store the neighbors of that vertex.
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]); //processes the given edges and populates the adjacency list. For each edge [u, v], it adds v
            adj.get(edge[1]).add(edge[0]);  //to the list of neighbors of u and vice versa since the graph is undirected.
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res++;
                bfs(adj, i, q, visited);
            }
        }

        return res;
    }

    //BFS to traverse the graph and identify connected components. The BFS function (bfs) takes the adjacency list (adj), the starting vertex (start), a queue (q), and a boolean array (visited) as parameters.
    private void bfs(
            List<List<Integer>> adj,
            int start,
            Queue<Integer> q,
            boolean[] visited
    ) {
        q.offer(start); // Enqueue the starting vertex and mark it as visited
        visited[start] = true;

        while (!q.isEmpty()) {
            Integer u = q.poll(); // Dequeue a vertex
            for (int neighbor : adj.get(u)) {
                if (!visited[neighbor]) {
                    q.offer(neighbor); // Enqueue unvisited neighbors
                    visited[neighbor] = true; // Mark neighbors as visited
                }
            }
        }
    }
}
