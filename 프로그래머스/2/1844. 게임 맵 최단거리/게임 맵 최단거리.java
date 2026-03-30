import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            int dist = cur[2];
            
            if(row == n-1 && col == m-1){
                return dist;
            }
            
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};
            
            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
                
                if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                    if(!visited[nr][nc] && maps[nr][nc] == 1){
                        queue.offer(new int[]{nr, nc, dist+1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        
        return -1;
    }
}