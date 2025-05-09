import java.util.*;

class Solution {
    static int n;
    static int[][] distance;

    public static int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length;
        distance = new int[n][n];

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }
        
        bfs(grid, 0,0);
        return distance[n-1][n-1];
    }

    public static boolean isValid(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < n;
    }

    public static void bfs(int[][] grid, int r, int c){
        int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1}; 
        int[] dc = {0, 0, -1, 1, -1, 1, -1, 1}; 

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < n; i++){
            Arrays.fill(distance[i], -1); // 거리 초기화
        }

		queue.offer(new int[]{r, c});
        distance[r][c] = 1;
		
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
    
            for (int i = 0; i < 8; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];
                if (isValid(nextRow, nextCol)) {
                    if (distance[nextRow][nextCol] == -1 && grid[nextRow][nextCol] == 0) {
                        queue.offer(new int[]{nextRow, nextCol});
                            distance[nextRow][nextCol] = distance[curRow][curCol] + 1;
                    }
                }
            }
        }
    }
}