import java.util.*;

class Solution {

    class pair {
        int f, s;

        pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }

    public void bfs(int r, int c, int[][] vis, char[][] grid) {

        vis[r][c] = 1;

        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(r, c));

        int n = grid.length;
        int m = grid[0].length;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!q.isEmpty()) {

            pair p = q.poll();
            int row = p.f;
            int col = p.s;

            for(int i = 0; i < 4; i++) {

                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m &&
                   grid[nr][nc] == '1' && vis[nr][nc] == 0) {

                    vis[nr][nc] = 1;
                    q.add(new pair(nr, nc));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        int count = 0;

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {

                if(vis[row][col] == 0 && grid[row][col] == '1') {
                    count++;
                    bfs(row, col, vis, grid);
                }
            }
        }

        return count;
    }
}