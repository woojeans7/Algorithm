import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] a;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    // 바깥 물 BFS - visited 체크
    static void bfs() {
        for (boolean[] row : visited) Arrays.fill(row, false);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m
                        && !visited[nr][nc] && a[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }

    // 바깥 물에 인접한 빙하를 동시에 녹임
    static int melt() {
        int cnt = 0;
        // 녹일 빙하를 먼저 수집 (동시성 보장)
        List<int[]> toMelt = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < m
                                && visited[nr][nc]) {
                            toMelt.add(new int[]{i, j});
                            break;
                        }
                    }
                }
            }
        }
        for (int[] cell : toMelt) {
            a[cell[0]][cell[1]] = 0;
            cnt++;
        }
        return cnt;
    }

    static boolean glacierExists() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (a[i][j] == 1) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                a[i][j] = Integer.parseInt(st.nextToken());
        }

        int time = 0, lastCnt = 0;
        do {
            bfs();
            lastCnt = melt();
            time++;
        } while (glacierExists());

        System.out.println(time + " " + lastCnt);
    }
}