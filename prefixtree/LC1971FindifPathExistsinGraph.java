import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC1971FindifPathExistsinGraph {
    //LINK: https://leetcode.com/problems/find-if-path-exists-in-graph/description/
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Create an adjacency list to represent the graph
        ArrayList<ArrayList<Integer>> adjucentNodes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjucentNodes.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjucentNodes.get(edges[i][0]).add(edges[i][1]);
            adjucentNodes.get(edges[i][1]).add(edges[i][0]);
        }
        // Initialize an array to keep track of visited nodes
        boolean isVisited[] = new boolean[n];
        // Perform BFS starting from the source node
        breadthFirst(source, adjucentNodes, isVisited);
        // Return true if the destination node was visited during the BFS, false
        // otherwise
        return isVisited[destination];
    }
    public void breadthFirst(int source, ArrayList<ArrayList<Integer>> adjucentNodesList, boolean[] isVisitedArr) {
        // Initialize a queue to hold nodes to visit
        Queue<Integer> nodesQueue = new LinkedList<>();
        nodesQueue.add(source);
        // Mark the source node as visited
        isVisitedArr[source] = true;
        // Continue visiting nodes until the queue is empty
        while (!nodesQueue.isEmpty()) {
            int currVertex = nodesQueue.poll();
            // Visit all neighbors of the current node that haven't been visited yet
            for (int i = 0; i < adjucentNodesList.get(currVertex).size(); i++) {
                int current = adjucentNodesList.get(currVertex).get(i);
                if (!isVisitedArr[current]) {
                    isVisitedArr[current] = true;
                    nodesQueue.add(current);
                }
            }
        }

    }
}
