import java.util.*;

class Solution {
    public int solution(int[][] city) {
        int answer = -1;
        int m = city.length;
        int n = city[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};

        boolean[][] visited = new boolean[m][n];

        // 시작점이 1이면 바로 종료
        if(city[0][0] == 1) return answer;

        // 거리를 큐에 같이 추가
        queue.offer(new int[]{0,0,1});

        // 방문 배열
        visited[0][0] = true;

        // 탐색
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            // 환자에게 도달하면 거리 반환
            if(r == m-1 && c == n-1){
                return dist;
            }

            for(int i=0; i<8; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                    if(!visited[nr][nc] && city[nr][nc] == 0){
                        queue.add(new int[]{nr, nc, dist + 1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return answer; // 찾을 수 없으면 -1 종료
    }
}