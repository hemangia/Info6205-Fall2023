import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC733FloodFill {
    /*
    Link: https://leetcode.com/problems/flood-fill/description/
  This problem is similar to Rotten orange, we jst have to change value and return matrix.
  BFS Approach :
  Time Complexity : O(M*N)
  Space Complexity : O(M * N)
  In BFS, if we ever confuse with when to take the size and when to not take the size, we can perform the same
  solution with size as well.
   */
    //                          right.  left.    up.      down.
    int[][] dirs = new int[][] {{0,1}, {0, -1}, {-1, 0}, {1, 0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> q =new LinkedList<>();
        if(image == null || image.length == 0) return image ;
        int origColor = image[sr][sc];
        image[sr][sc] = newColor;
        if(origColor == newColor) return image ;
        q.add(new int[]{sr, sc});
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i < size; i++){
                int curr[] = q.poll();
                for(int dir[] : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr >=0 && nc >=0 && nr < image.length && nc < image[0].length && image[nr][nc] == origColor){
                        image[nr][nc] = newColor ;
                        q.add(new int[]{nr, nc});
                    }
                }

            }

        }
        return image;
    }
}
