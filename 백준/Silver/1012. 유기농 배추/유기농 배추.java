import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 세로
            int N = Integer.parseInt(st.nextToken()); // 가로
            int K = Integer.parseInt(st.nextToken());

            // 1. 배열 선언
            int[][] farm = new int[N][M];

            for(int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                // 2. 배열 채우기
                farm[Y][X] = 1;

            }

            // 디버깅
            //for(int j = 0; j < N; j++){
            //    System.out.println(Arrays.toString(farm[j]));
            //}
            //break;

            // 3. DFS 실행
            boolean[][] visited = new boolean[N][M];
            int answer = 0;

            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    // 땅이 0이거나 방문한적 있으면 패스
                    if(farm[j][k] == 0 || visited[j][k]) continue;
                    dfs(farm, j,k, visited, N, M);
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }
    private static void dfs(int[][] graph, int r, int c, boolean[][] visited, int N, int M){
        // 현재 위치 방문
        visited[r][c] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // 다음 위치 탐색
        for(int j = 0; j < 4; j++){
            int nr = r + dr[j];
            int nc = c + dc[j];

            if(0 <= nr && nr < N && 0 <= nc && nc < M){
                if(!visited[nr][nc] &&  graph[nr][nc] == 1){
                    dfs(graph, nr, nc, visited, N, M);
                }
            }
        }
    }
}
