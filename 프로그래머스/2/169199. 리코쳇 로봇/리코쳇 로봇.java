import java.util.*;

class Solution {
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        char[][] newBoard = new char[n][m];
        int[] start = new int[3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                newBoard[i][j] = board[i].charAt(j);
                if(newBoard[i][j] == 'R'){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }    
        
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            int dist = cur[2];
            
            if(newBoard[row][col] == 'G' && visited[row][col]){
                return dist;
            }
            
            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
                
                 // D를 만날 때까지 이동
                while(nr >= 0 && nr < n && nc >= 0 && nc < m && newBoard[nr][nc] != 'D'){
                    nr += dr[i];
                    nc += dc[i];
                }
                
                nr -= dr[i];
                nc -= dc[i];
                
                if(!visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, dist+1});
                }
            }
           
        }
        return -1;
    }
}