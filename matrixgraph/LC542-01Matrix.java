import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC542-01Matrix {
      /*
    In this problem, we have to find the 1s and replace it with the nearest 0th distance.

    BFS Approach :
    In this approach, we have to find all independent nodes, and put it into the queue.
    Then we will use direction array and check if its value is -1.
    If then yes replace it with t where t is the level and for every level we will increase the t value.
    Time Complexity : O(M*N)
    Space Complexity : O(M*N)
     */
public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length ;
        //                          right.  left.    up.      down.
        int[][] dirs = new int[][] {{0,1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> q = new LinkedList<>();
        for(int i =0 ;i < m;i++){
        for(int j=0; j< n; j++){
        if(mat[i][j] == 0){
        q.add(new int[]{i,j});
        }
        else if(mat[i][j] == 1){
        mat[i][j] = -1 ;
        }
        }
        }
        int dist= 1 ;
        while(!q.isEmpty()){

        int size = q.size();
        for(int i =0 ; i< size;i++){
        int[] curr = q.poll();
        int r = curr[0];
        int c = curr[1];
        for(int[] dir : dirs){
        int nr = dir[0] + r ;
        int nc = dir[1] + c ;
        if(nr>=0 && nc>=0 && nr<m && nc<n && mat[nr][nc] == -1){
        mat[nr][nc] = dist ;
        q.add(new int[]{nr,nc});
        }
        }
        }
        dist = dist +1 ;
        }
        return mat ;
        }
}
