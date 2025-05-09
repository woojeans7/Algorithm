import java.util.*;

class Solution {
    static int m;
    static int n;
    static int[][] times;
    public static int solution(String[] maps) {
        m = maps.length;
        n = maps[0].length();
        times = new int[m][n];
        int[] start = null;
        int[] end = null;
        int[] lever = null;

        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = maps[i].charAt(j);
                if (grid[i][j] == 'S') {
                    start = new int[]{i, j};
                }
                else if (grid[i][j] == 'E') {
                    end = new int[]{i, j};
                }
                else if (grid[i][j] == 'L') {
                    lever = new int[]{i, j};
                }
            }
        }

        bfs(start, lever, grid);
        int toLever = times[lever[0]][lever[1]];
        if (toLever == -1) return -1;

        bfs(lever, end, grid);
        int toEnd = times[end[0]][end[1]];
        if (toEnd == -1) return -1;

        return toLever + toEnd;
    }

    public static void bfs(int[] from, int[] to, char[][] grid) {
        int[] dr = {-1, 1, 0, 0,};
        int[] dc = {0, 0, -1, 1};
        
        for (int i = 0; i < m; i++) {
            Arrays.fill(times[i], -1);
        }   
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(from);
        times[from[0]][from[1]] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            if(curRow == to[0] && curCol == to[1]){return;}

            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];
                if (isValid(nextRow, nextCol)) {
                    if (times[nextRow][nextCol] == -1 && grid[nextRow][nextCol] != 'X') {
                        queue.offer(new int[]{nextRow, nextCol});
                        times[nextRow][nextCol] = times[curRow][curCol] + 1;
                    }
                }
            }

        }
    }
    public static boolean isValid(int r, int c) {
        return 0 <= r && r < m && 0 <= c && c < n;
    }
}