import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC200NumberofIslands {
    /*
    Link: https://leetcode.com/problems/number-of-islands/description/
      In this problem, they have given an array of 1s and 0s. 1 is land and 0 is water. We have to find total count of
      island which forms with adjacent 1s.

      BFS Approach :
      In this we will start iterating through matrix.
      1)  Once we found the 1 we will increase the count = count +1 , we will put it into the queue.
      2)  We will make that 1 to 0 so that it can not come again while iterating.
      3)  We wil find its adjacent 1, put it into queue and change it to 0.
      4)  Whenever our queue is empty, that means our island is complete.
      5)  Then we will start again iterating through matrix and find another 1 for finding another island.

      Time Complexity  : O(2*M*N)
      Space Complexity : O(M) => min(m,n). In the queue, at the time only longest diagonal will be present. Therefore O(M)
       */
    public int numIslands(char[][] grid) {

        //                          right.  left.    up.      down.
        int[][] dirs = new int[][] {{0,1}, {0, -1}, {-1, 0}, {1, 0}};
        int m = grid.length ;
        int n = grid[0].length ;
        Queue<int[]> q = new LinkedList<>();
        int count = 0 ;
        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    count = count +1; // Make sure to increase here for every island and not inside.
                    grid[i][j] = '0';
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int curr[] = q.poll();
                        for(int[] dir: dirs){
                            int nr= curr[0] + dir[0];
                            int nc= curr[1] + dir[1];
                            if(nr>=0 && nc >= 0 && nr<m && nc<n && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                q.add(new int[]{nr,nc});
                            }
                        }
                    }

                }
            }
        }
        return count ;
    }
}
