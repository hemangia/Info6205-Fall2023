import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC994RottingOranges {
    /*
    Link: https://leetcode.com/problems/rotting-oranges/description/
   In this problem we have given matrix with values 0,1,2
   2 means rotten, 1 means fresh, 0 means no orange.
   At every pass our 2 neighbors will become rotten and we have to find the time where all the fresh oranges becomes
   rotten.
   BFS Approach :
   1)  In this, we will maintain a queue, where we initially put all rotten oranges.
   2)  we will have count of all fresh oranges.
   3)  We will iterate through rotten orange and check its neighbors whether they are fresh or not.
       If fresh make it rotten and add into the queue, decrease the freshCount - 1 and change its value to 2.
   4)  We will be having size of queue and at every level we are increasing the time t .
   5)  At the end we wil check if fresh count is 0, then return t else return -1
   Time Complexity: O(4*M*N) for checking all the rotten oranges and putting inside the queue.
   In bfs, we wil go through all the nodes, total time complexity will be O(M*N)
   Space Complexity: O(M*N)

    */
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int freshCount= 0;
        int t = 0; //time
        //                          right.  left.    up.      down.
        int[][] dirs = new int[][] {{0,1}, {0, -1}, {-1, 0}, {1, 0}};
        int m = grid.length ;
        int n = grid[0].length;
        for(int i=0;i<=m-1;i++){
            for(int j=0;j<=n-1;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    freshCount ++ ;
                }

            }
        }
        if(freshCount == 0){
            return 0 ;
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size; i++){
                int curr[] = q.poll();
                for(int dir[] : dirs){
                    int r = dir[0];
                    int c = dir[1];
                    int nr = r + curr[0];
                    int nc = c + curr[1];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc] == 1){ // make sure to check boundries of grid.
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr,nc});
                        freshCount -- ;

                    }
                }

            }
            t ++ ;
        }
        if(freshCount==0){
            return t - 1; // It is 1 becoz last step will be process and time gone 1 step ahead.
        }
        return -1  ;
    }
}
