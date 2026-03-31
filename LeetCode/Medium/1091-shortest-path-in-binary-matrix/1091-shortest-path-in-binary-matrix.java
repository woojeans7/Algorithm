class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        if(grid[0][0] == 1  || grid[n-1][n-1] == 1) return -1;

        int[][] distance = new int[n][n];
        for(int[] d : distance){
            Arrays.fill(d, -1);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});

        distance[0][0] = 1;

        int[] dr = {-1,1,0,0,-1,1,-1,1};
        int[] dc = {0,0,-1,1,-1,1,1,-1};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];

            for(int i = 0; i < 8; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n){
                    if(distance[nr][nc] == -1 && grid[nr][nc] == 0){
                        distance[nr][nc] = distance[row][col] + 1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return distance[n-1][n-1];
    }
}