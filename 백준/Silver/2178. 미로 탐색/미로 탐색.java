import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    final static int[] dr = {-1, 1, 0, 0};
    final static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(line[j]);
            }
        }

        int answer = bfs(maze);
        System.out.println(answer);
    }

    public static int bfs(int[][] maze) {
        // 큐, 방문배열 초기화
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        // 시작점 예약 (시작 좌표, 거리), 방문처리
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        // 탐색 시작
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            if(r == N-1 && c == M-1) {
                return dist;
            }

            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < N && nc >= 0 && nc < M && maze[nr][nc] != 0) {
                    if(!visited[nr][nc]) {
                        queue.offer(new int[]{nr, nc, dist + 1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return -1;
    }
}
