import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N + 1][M + 1]; // 1-indexed
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) grid[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            // 1) 경계 시계방향 1칸 회전
            List<int[]> border = new ArrayList<>();
            for (int c = c1; c <= c2; c++) border.add(new int[]{r1, c});        // 상단 좌->우
            for (int r = r1 + 1; r <= r2; r++) border.add(new int[]{r, c2});    // 우측 위->아래
            for (int c = c2 - 1; c >= c1; c--) border.add(new int[]{r2, c});    // 하단 우->좌
            for (int r = r2 - 1; r >= r1 + 1; r--) border.add(new int[]{r, c1});// 좌측 아래->위

            int len = border.size();
            int[] vals = new int[len];
            for (int i = 0; i < len; i++) vals[i] = grid[border.get(i)[0]][border.get(i)[1]];
            for (int i = 0; i < len; i++) {
                int[] p = border.get(i);
                grid[p[0]][p[1]] = vals[(i - 1 + len) % len];
            }

            // 2) 평균(버림) 동시 갱신, 인접은 "전체 격자" 기준
            int[][] next = new int[N + 1][M + 1];
            for (int i = r1; i <= r2; i++)
                for (int j = c1; j <= c2; j++) {
                    int sum = grid[i][j], cnt = 1;
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dr[d], nj = j + dc[d];
                        if (ni >= 1 && ni <= N && nj >= 1 && nj <= M) { sum += grid[ni][nj]; cnt++; }
                    }
                    next[i][j] = sum / cnt; // 음수 없으므로 정수나눗셈 == 버림
                }
            for (int i = r1; i <= r2; i++)
                for (int j = c1; j <= c2; j++) grid[i][j] = next[i][j];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sb.append(grid[i][j]);
                if (j < M) sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}