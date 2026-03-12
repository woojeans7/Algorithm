import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        char[][] miro = new char[n][m];
        
        for(int i = 0; i < n; i++){
            miro[i] = maps[i].toCharArray();
        }
        
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];
        
        for(int i = 0; i< n; i++){
            for(int j = 0; j < m; j++){
                if(miro[i][j] == 'S'){
                    start[0] = i;
                    start[1] = j;
                }
                else if(miro[i][j] == 'L'){
                    lever[0] = i;
                    lever[1] = j;
                }
                else if(miro[i][j] == 'E'){
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        
        // System.out.println(Arrays.deepToString(miro));
        
        int toLever = bfs(miro, n, m, start, lever);
        int toEnd = bfs(miro, n, m, lever, end);
        if(toLever == -1 || toEnd == -1) return -1;
        
        return toLever + toEnd;
    }
    
    public int bfs(char[][] miro, int n, int m, int[] start, int[] end){
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] distance = new int[n][m];
        for (int[] d : distance) {
            Arrays.fill(d, -1);  // 각 행(int[])을 -1로 채움
        }
        
        queue.add(start);
        distance[start[0]][start[1]] = 0;
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0,0,-1,1};
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            
            if(row == end[0] && col == end[1]){
                return distance[row][col];
            }
            
            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
                
                if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                    if(distance[nr][nc] == -1 && miro[nr][nc] != 'X'){
                        distance[nr][nc] = distance[row][col] + 1;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return -1;
    }
}