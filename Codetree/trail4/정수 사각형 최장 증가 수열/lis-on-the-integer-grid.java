import java.io.*;
import java.util.*;

public class Main {
    public int solution(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];

        // 모든 칸을 값 기준 오름차순 정렬
        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cells.add(new int[]{i, j});

        cells.sort((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);

        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};

        Arrays.fill(dp[0], 1);  // 사실 아래서 초기화하므로 필요 없음
        for (int[] row : dp) Arrays.fill(row, 1);  // 최소 1칸

        int answer = 1;

        for (int[] cell : cells) {
            int i = cell[0], j = cell[1];

            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];

                if (ni < 0 || nj < 0 || ni >= n || nj >= n) continue;

                // 인접 칸이 나보다 작으면 → 그 칸에서 이어받기
                if (grid[ni][nj] < grid[i][j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[ni][nj] + 1);
                }
            }

            answer = Math.max(answer, dp[i][j]);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main main = new Main();
        System.out.println(main.solution(A));
    }
}
