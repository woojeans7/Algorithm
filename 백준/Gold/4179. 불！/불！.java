import java.util.*;
import java.io.*;

/*
    BAEKJOON 4179번 불!
    https://www.acmicpc.net/problem/4179
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] grid = new char[N][M];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            grid[i] = line.toCharArray();
        }

        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> fires = new LinkedList<>();
        int[][] distances = new int[N][M]; // 지훈
        int[][] visited = new int[N][M]; // 불

        for(int i = 0; i < N; i++){
            Arrays.fill(distances[i], -1);
            Arrays.fill(visited[i], -1);
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(grid[i][j] == 'J') {
                    queue.add(new int[]{i, j});
                    distances[i][j] = 1;
                }
                else if(grid[i][j] == 'F'){
                    fires.add(new int[]{i, j});
                    visited[i][j] = 1;
                }
            }
        }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // 불의 경로
        while(!fires.isEmpty()){
            int[] cur = fires.poll();
            int row = cur[0];
            int col = cur[1];

            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M){
                    if(visited[nr][nc] == -1 && grid[nr][nc] != '#'){
                        fires.add(new int[]{nr, nc});
                        visited[nr][nc] = visited[row][col] + 1;
                    }
                }
            }
        }

        // 지훈이 경로
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];

            if(row == 0 || row == N-1 || col == 0 || col == M-1){
                System.out.println(distances[row][col]);
                return;
            }

            for(int i = 0; i < 4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < N && nc >= 0 && nc < M){
                    if(distances[nr][nc] == -1 && grid[nr][nc] == '.'){
                        int nextTime = distances[row][col] + 1;
                        if(visited[nr][nc] == -1 || visited[nr][nc] > nextTime){
                            queue.add(new int[]{nr, nc});
                            distances[nr][nc] = nextTime;
                        }
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
