import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC207CourseSchedule {
    /*
    Link: https://leetcode.com/problems/course-schedule/description/
   1) Topological Sort Approach:

   We will make indegrees array and adjacency list.
   Here we are maintaining 3 things
   1) Map for maintaining relation between, Independent Node : Dependent list
   2) Add the same time We have an Array where we maintaing How many nodes the current index it dependent.
   3) Queue : Whenever node becomes independent, indegree value of array becomes 0, we will push inside the queue.
   Example: [(1,0), (4,1), (3,2),   (3,1),  (2,0),  (5,4),  (5,2)]
   Map:
   {0 : [1,    2]
    1 : [4,    3]
    2 : [3,    5]
    3 : []
    4 : [5]
    5:  []
   }
   Array:
    0  1   2   3   4   5
   [0, 1,  1,  2,  1 , 2]



   Whoever is becoming independent which means degree in array becomes 0, we will be pushing inside the queue.
   Whenever we are pushing a node inside the queue, we are maintaining a count. We will check is this count is equal
   to total no of courses. We can also check if indegrees arrays all items become zero.

   If we have a cyclic dependency in a graph, we wil not be ablr to proceed further and our output will be false.
   Suppose we have 2 nodes with 0 dependency, since this is bfs, we will add all the nodes, and not any.

   Time Complexity: O(E+V)
   Space Complexity : O(E+V)

    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] dependency = new int[numCourses];

        Queue<Integer> q = new LinkedList<>();
        for(int[] a : prerequisites){
            int num = a[0];
            dependency[num] =  dependency[num] + 1 ;
            if(map.get(a[1])==null){
                map.put(a[1], new ArrayList<>());

            }
            map.get(a[1]).add(a[0]);
        }
        int count = 0;
        // This block is for initial nodes which doesnt have any dependency. Suppose we have 2 nodes which has 0
        //dependecy, we will add those in our queue
        for(int i=0;i<=dependency.length -1 ;i++){
            if(dependency[i] == 0){
                q.add(i);
                count ++ ;
            }
        }

        while(!q.isEmpty()){
            int n =  q.poll();
            List<Integer> l = map.get(n);
            if(l!=null){
                for(int child : l){
                    dependency[child] = dependency[child] - 1 ;
                    if(dependency[child] == 0){
                        q.add(child);
                        count ++ ;
                    }
                }
            }


        }
        if(count == numCourses){
            return true ;
        }
        return false ;
    }
}
