import java.io.*;
import java.util.*;

public class Main {
    public int[][] solution(int[][] grid) {
        // 시작점 구하기 - 2일 때 시작
        int n = grid.length;

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] distance = new int[n][n];


        for(int i = 0; i < n; i++){
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

                if(nr >= 0 && nr < n && nc >= 0 && nc < n){
                    // distance 배열에 각 오렌지 위치 표시 후 시간 지날 때마다 +1
                    if(distance[nr][nc] == -1 && grid[nr][nc] == 1){
                        queue.offer(new int[]{nr, nc});
                        distance[nr][nc] = distance[row][col] + 1;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(distance[i][j] == -1 && grid[i][j] == 1){
                    distance[i][j] = -2;
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main main = new Main();
        int[][] answer = main.solution(A);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
