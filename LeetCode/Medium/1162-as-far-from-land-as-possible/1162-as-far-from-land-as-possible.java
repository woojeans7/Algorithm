class Solution {
    public int maxDistance(int[][] grid) {
        
        int n = grid.length;

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] distance = new int[n][n];
        
        for(int[] dist : distance) Arrays.fill(dist, -1);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i, j});
                    distance[i][j] = 0;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0 ,-1, 1};

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            int r = cur[0];
            int c = cur[1];

            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n){
                    if(distance[nr][nc] == -1 && grid[nr][nc] == 0){
                        queue.offer(new int[]{nr, nc});
                        distance[nr][nc] = distance[r][c] + 1;
                    }
                }
            }
        }

        int max = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                max = Math.max(distance[i][j], max);
            }
        }
        return max == 0 ? -1 : max;
    }
}