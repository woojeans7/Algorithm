import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int n = places.length;
        int[] answer = new int[n];

        // bfs로 거리두기 체크하는 로직
        for(int i = 0; i < n; i++){
            answer[i] = check(places[i]);
        }
        
        return answer;
    }
    private int check(String[] place){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(place[i].charAt(j) == 'P'){
                    if(!bfs(i,j,place)) return 0;
                }
            }
        }
        return 1;
    }
    private boolean bfs(int row, int col, String[] place){
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] distance = new int[5][5];
        for(int[] d : distance){
            Arrays.fill(d, -1);
        }
        queue.offer(new int[]{row, col});
        distance[row][col] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            if(distance[r][c] >= 2) continue;
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && place[nr].charAt(nc) != 'X'){
                    if(distance[nr][nc] == -1){
                        if (place[nr].charAt(nc) == 'P') return false;
                        queue.offer(new int[]{nr, nc});
                        distance[nr][nc] = distance[r][c] + 1;
                    }
                }
            }
        }
        return true;
    }
}