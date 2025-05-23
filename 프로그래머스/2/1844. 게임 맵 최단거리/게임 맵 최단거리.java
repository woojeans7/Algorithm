import java.util.*;

class Solution {
    static int n;
    static int m;
    public int solution(int[][] maps) {
        // BFS로 최단거리 구하기
        n = maps.length;
        m = maps[0].length;
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        // 시작점 예약 (0,0 , 거리 0)
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            // 현재 노드 방문
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];
            
            // if 도착지 도달하면 return dist
            if(r == n-1 && c == m-1) return dist;
            
            // 다음 노드 예약
            for(int i=0; i <4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(isValid(nr, nc)){
                    if(maps[nr][nc] == 1 && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc, dist + 1});
                    }
                }
            }
        }
        return -1;
    }
    public boolean isValid(int r, int c){
        return (r >= 0 && r < n && c >= 0 && c < m);
    }
}