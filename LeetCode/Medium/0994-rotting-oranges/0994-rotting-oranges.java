class Solution {
    public int orangesRotting(int[][] grid) {
        // 시작점 구하기 - 2일 때 시작
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] distance = new int[m][n];


        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                distance[i][j] = -1;

                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                    distance[i][j] = 0;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];

            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                    // distance 배열에 각 오렌지 위치 표시 후 시간 지날 때마다 +1
                    if(distance[nr][nc] == -1 && grid[nr][nc] == 1){
                        queue.offer(new int[]{nr, nc});
                        distance[nr][nc] = distance[row][col] + 1;
                    }
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && distance[i][j] == -1){
                    return -1;
                }
                answer = Math.max(answer, distance[i][j]);
            }
        }
        return answer;
    }
}