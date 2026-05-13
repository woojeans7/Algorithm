import java.io.*;
import java.util.*;

public class Main {
    int n;
    int[] dr =  {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int[][] solution(int[][] board, int h) {
        n = board.length;
        List<int[]> pos = new ArrayList<>();

        // 시작점 찾기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    pos.add(new int[]{i, j, 0});
                }
            }
        }

        int[][] answer = new int[n][n];

        for(int k = 0; k < h; k++){
            int[] start = pos.get(k);
            int result = bfs(board, start);
            answer[start[0]][start[1]] = result;
        }

        return answer;
    }
    private int bfs(int[][] board, int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            int dist = cur[2];

            if(board[row][col] == 3) return dist;

            for(int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    if(board[nr][nc] != 1){
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc, dist + 1});
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
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main main = new Main();
        int[][] result = main.solution(A, H);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
