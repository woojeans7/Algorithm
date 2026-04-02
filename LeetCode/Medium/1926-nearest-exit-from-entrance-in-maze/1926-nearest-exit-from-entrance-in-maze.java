class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] distance = new int[m][n];
        queue.offer(entrance);

        for(int[] d : distance){
            Arrays.fill(d, -1);
        }
        distance[entrance[0]][entrance[1]] = 0;

        // 4방향 탐색
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];

            for(int i = 0; i < 4; i++){
                
                int nr = row + dr[i];
                int nc = col + dc[i];

                // 방문한 적 없고, .일 경우에만 이동할 수 있음
                if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                    if(distance[nr][nc] == -1 && maze[nr][nc] == '.'){
                        // 조기종료 조건 각 행, 열이 0이거나 M, N에 도달했을 경우
                        if(nr == 0 || nr == m-1 || nc == 0 || nc == n-1){
                            return distance[row][col] + 1;
                        }
                        queue.offer(new int[]{nr, nc});
                        distance[nr][nc] = distance[row][col] + 1;
                    }
                }
            }
        }

        return -1;
    }
}