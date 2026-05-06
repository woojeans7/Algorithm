import java.io.*;
import java.util.*;

public class Main {
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};

    public int solution(int n, int m, int[][] grid, int[][] startPoints, List<int[]> stones) {
        boolean[] removed = new boolean[stones.size()];
        return combination(removed, 0, 0, m, n, grid, startPoints, stones);
    }

    private int combination(boolean[] removed, int idx, int count, int m,
                            int n, int[][] grid, int[][] startPoints, List<int[]> stones) {
        if (count == m) {
            return bfs(removed, n, grid, startPoints, stones);
        }
        if (idx == stones.size()) return 0;

        // 이 돌을 제거
        removed[idx] = true;
        int with = combination(removed, idx + 1, count + 1, m, n, grid, startPoints, stones);

        // 이 돌을 제거하지 않음
        removed[idx] = false;
        int without = combination(removed, idx + 1, count, m, n, grid, startPoints, stones);

        return Math.max(with, without);
    }

    private int bfs(boolean[] removed, int n, int[][] grid,
                    int[][] startPoints, List<int[]> stones) {
        // 제거된 돌 임시 반영
        for (int i = 0; i < stones.size(); i++) {
            if (removed[i]) {
                grid[stones.get(i)[0]][stones.get(i)[1]] = 0;
            }
        }

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int[] start : startPoints) {
            visited[start[0]][start[1]] = true;
            queue.offer(start);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            count++;
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n
                        && !visited[nr][nc] && grid[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        // 돌 원복
        for (int i = 0; i < stones.size(); i++) {
            if (removed[i]) {
                grid[stones.get(i)[0]][stones.get(i)[1]] = 1;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][N];
        List<int[]> stones = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) stones.add(new int[]{i, j});
            }
        }

        int[][] startPoints = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            startPoints[i][0] = Integer.parseInt(st.nextToken()) - 1;
            startPoints[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        Main main = new Main();
        System.out.println(main.solution(N, M, grid, startPoints, stones));
    }
}