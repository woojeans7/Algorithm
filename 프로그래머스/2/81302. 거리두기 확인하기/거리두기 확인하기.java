import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0,};
    static int[] dc = {0, 0, -1, 1};

    public static int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            char[][] grid = new char[5][5];

            for (int j = 0; j < 5; j++) {
                grid[j] = places[i][j].toCharArray();
            }

            boolean valid = true;

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    // 시작점 예약
                    boolean[][] visited = new boolean[5][5];
                    Queue<int[]> queue = new ArrayDeque<>();
                    if (grid[j][k] == 'P') {
                        queue.offer(new int[]{j, k, 0});
                        visited[j][k] = true;

                        // 방문
                        while (!queue.isEmpty()) {
                            int[] cur = queue.poll();
                            int r = cur[0];
                            int c = cur[1];
                            int dist = cur[2];

                            if (dist >= 1 && grid[r][c] == 'P') {
                                valid = false;
                                break;
                            }

                            if (dist == 2) continue;

                            // 예약
                            for(int t=0; t<4; t++){
                                int nr = r + dr[t];
                                int nc = c + dc[t];
                                if((0 <= nr && nr < 5) && (0 <= nc && nc < 5) && grid[nr][nc] != 'X'){
                                    if(!visited[nr][nc]){
                                        visited[nr][nc] = true;
                                        queue.offer(new int[]{nr, nc, dist + 1});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            answer[i] = valid ? 1 : 0;
        }
        return answer;
    }
}