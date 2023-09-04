/**
bfs -> Breath First Search
define visited[][] -> check whether i previously visited 
define Queue system so put the spot where i didn't visit
once queue is empty -> move on to next i,j 
we have to check whether we visited or not anyway before you visit each next i,j 
 */
 import java.util.*;

class Solution {
    /**
       -10
    0-1 00 0 1
       10
     */
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};

    static boolean[][] visited;
    static Queue<Spot> q = new LinkedList();


    public void bfs(Spot input, char[][] grid) {

        q.add(input);
        
        while(!q.isEmpty()) {
            Spot spot = q.poll();
            int x = spot.x;
            int y = spot.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) {
                    continue;
                }
                if (grid[nx][ny] == '1' && visited[nx][ny] == false) {
                    q.add(new Spot(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        
    }
    
    public int numIslands(char[][] grid) {
        
        visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == false && grid[i][j] == '1') {
                    visited[i][j] = true;
                    bfs(new Spot(i, j), grid);
                    count++;
                }
                
            }
        }


        return count;
    }

    public class Spot {
        int x;
        int y;

        public Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}