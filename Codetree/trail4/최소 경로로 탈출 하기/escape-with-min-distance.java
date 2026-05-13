import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(new int[] {0, 0, 0});
        visited[0][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row =  cur[0];
            int col = cur[1];
            int dist = cur[2];

            if(row == n-1 && col == m-1) return dist;

            for(int i = 0; i < 4; i++) {
                int nr  = row + dr[i];
                int nc = col + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
                    if(board[nr][nc] == 1) {
                        queue.offer(new int[] {nr, nc, dist + 1});
                        visited[nr][nc] = true;
                    }
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main main = new Main();
        System.out.println(main.solution(A));
    }
}
