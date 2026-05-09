import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1; // 1-indexed → 0-indexed
            char d = st.nextToken().charAt(0);

            // 1. 바람 맞은 행을 d 방향으로 shift
            shift(r, d);

            // 2. 위로 전파: 직전 밀린 행은 r, 다음 행은 반대 방향
            char curDir = d;
            for (int i = r - 1; i >= 0; i--) {
                if (!hasCommon(i, i + 1)) break;
                curDir = opposite(curDir);
                shift(i, curDir);
            }

            // 3. 아래로 전파
            curDir = d;
            for (int i = r + 1; i < N; i++) {
                if (!hasCommon(i, i - 1)) break;
                curDir = opposite(curDir);
                shift(i, curDir);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(grid[i][j]);
                if (j < M - 1) sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    // dir 방향에서 바람이 불어옴
    // L = 왼쪽에서 바람 → 행이 오른쪽으로 밀림
    // R = 오른쪽에서 바람 → 행이 왼쪽으로 밀림
    static void shift(int row, char dir) {
        if (dir == 'L') { // 오른쪽으로 shift
            int last = grid[row][M - 1];
            for (int j = M - 1; j > 0; j--) grid[row][j] = grid[row][j - 1];
            grid[row][0] = last;
        } else { // 'R' → 왼쪽으로 shift
            int first = grid[row][0];
            for (int j = 0; j < M - 1; j++) grid[row][j] = grid[row][j + 1];
            grid[row][M - 1] = first;
        }
    }

    // 두 행에 같은 열에서 같은 숫자가 하나라도 있는지
    static boolean hasCommon(int r1, int r2) {
        for (int j = 0; j < M; j++) {
            if (grid[r1][j] == grid[r2][j]) return true;
        }
        return false;
    }

    static char opposite(char d) {
        return d == 'L' ? 'R' : 'L';
    }
}