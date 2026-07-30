import java.io.*;
import java.util.*;

public class Main {
    public int[][] solution(int n, int[][] board, int[] bomb) {
        int answer = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int r = bomb[0] - 1;
        int c = bomb[1] - 1;
        int v = board[r][c];
        
        // 폭탄 처리
        board[r][c] = 0;
        for(int i = 0; i < 4; i++) {
            for(int step = 1; step < v; step++) {
                int nr = r + dr[i] * step;
                int nc = c + dc[i] * step;

                if(nr < 0 || nr >= n || nc < 0 || nc >= n) break;

                board[nr][nc] = 0;
            }
        }

        // 중력 처리
        for(int col = 0; col < n; col++) {
            List<Integer> tmp = new ArrayList<>();
            for(int row = 0; row < n; row++) {
                if(board[row][col] != 0) tmp.add(board[row][col]);
            }
            // 이제 tmp에는 이 열의 0이 아닌 값들이 순서대로 담김
            // 아래부터 채우기
            int count = n - tmp.size();
            for(int row = 0; row < n; row++) {
                if(row < count) board[row][col] = 0;
                else board[row][col] = tmp.get(row - count);
            }
        }

        return board;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] B = new int[2];
        st = new StringTokenizer(br.readLine());
        B[0] = Integer.parseInt(st.nextToken());
        B[1] = Integer.parseInt(st.nextToken());

        Main main = new Main();
        int[][] board = main.solution(N, arr, B);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
