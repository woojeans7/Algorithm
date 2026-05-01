import java.io.*;
import java.util.*;

public class Main {
    public String solution(int n, int k, int[][] board, int[] start) {

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int row = start[0];
        int col = start[1];

        for(int count = 0; count < k; count++) {
            boolean[][] visited = new boolean[n][n];
            Queue<int[]> queue = new LinkedList<>();
            visited[row][col] = true;
            queue.offer(new int[]{row, col});

            int max = -1;
            while(!queue.isEmpty()) {
                int[] cur = queue.poll();

                for(int i = 0; i < 4; i++) {
                    int nr = cur[0] + dx[i];
                    int nc = cur[1] + dy[i];

                    if(isValid(nr, nc, n) && !visited[nr][nc]) {
                        if(board[nr][nc] < board[row][col]) {
                            visited[nr][nc] = true;
                            max = Math.max(max, board[nr][nc]);
                            queue.offer(new int[]{nr, nc});
                        }
                    }
                }
            }

            if(max == -1) break;

            int[] pos = findPriority(max, board, n, visited);
            row = pos[0];
            col = pos[1];
        }

        return (row + 1) + " " + (col + 1);
    }
    private int[] findPriority(int max, int[][] board, int n, boolean[][] visited) {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] && board[i][j] == max){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private boolean isValid(int row, int col, int n){
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] pos = new int[2];
        st = new StringTokenizer(br.readLine());
        pos[0] = Integer.parseInt(st.nextToken()) - 1;
        pos[1] = Integer.parseInt(st.nextToken()) - 1;

        Main main = new Main();
        System.out.println(main.solution(N, K, board, pos));
    }
}
