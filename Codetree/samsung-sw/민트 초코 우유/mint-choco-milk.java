import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static final int MINT = 1, CHOCO = 2, MILK = 4;
    int N, T;
    int[][] food;
    int[][] belief;
    // 0=위, 1=아래, 2=왼쪽, 3=오른쪽
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        food = new int[N][N];
        belief = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                food[i][j] = charToMask(line.charAt(j));
            }
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                belief[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int day = 0; day < T; day++) {
            morning();
            List<int[]> reps = lunch();
            evening(reps);
            sb.append(daySummary()).append('\n');
        }
        System.out.print(sb);
    }

    int charToMask(char c) {
        if (c == 'T') return MINT;
        if (c == 'C') return CHOCO;
        return MILK;
    }

    void morning() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                belief[i][j]++;
    }

    // 같은 음식끼리 그룹핑 + 대표자에게 신앙심 이전, 그룹별 대표자 좌표 반환
    List<int[]> lunch() {
        boolean[][] visited = new boolean[N][N];
        List<int[]> reps = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;

                List<int[]> group = new ArrayList<>();
                Deque<int[]> queue = new ArrayDeque<>();
                queue.add(new int[]{i, j});
                visited[i][j] = true;
                int f = food[i][j];

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    group.add(cur);
                    for (int d = 0; d < 4; d++) {
                        int nr = cur[0] + dr[d];
                        int nc = cur[1] + dc[d];
                        if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                        if (visited[nr][nc] || food[nr][nc] != f) continue;
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }

                int[] rep = group.get(0);
                for (int[] cand : group) {
                    if (isBetterRep(cand, rep)) rep = cand;
                }

                int size = group.size();
                if (size > 1) {
                    for (int[] cand : group) {
                        if (cand[0] == rep[0] && cand[1] == rep[1]) continue;
                        belief[cand[0]][cand[1]]--;
                    }
                    belief[rep[0]][rep[1]] += (size - 1);
                }
                reps.add(rep);
            }
        }
        return reps;
    }

    boolean isBetterRep(int[] cand, int[] rep) {
        int bc = belief[cand[0]][cand[1]], br = belief[rep[0]][rep[1]];
        if (bc != br) return bc > br;
        if (cand[0] != rep[0]) return cand[0] < rep[0];
        return cand[1] < rep[1];
    }

    void evening(List<int[]> reps) {
        // 단일(1) -> 이중(2) -> 삼중(3) 순, 같은 카테고리 내에서는 신앙심 desc, row asc, col asc
        reps.sort((a, b) -> {
            int ca = Integer.bitCount(food[a[0]][a[1]]);
            int cb = Integer.bitCount(food[b[0]][b[1]]);
            if (ca != cb) return ca - cb;
            int ba = belief[a[0]][a[1]], bb = belief[b[0]][b[1]];
            if (ba != bb) return bb - ba;
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        boolean[][] defended = new boolean[N][N];

        for (int[] rep : reps) {
            int r = rep[0], c = rep[1];
            if (defended[r][c]) continue;

            int B = belief[r][c];
            int origFood = food[r][c];
            int dir = B % 4;
            belief[r][c] = 1;
            int x = B - 1;

            int nr = r, nc = c;
            while (x > 0) {
                nr += dr[dir];
                nc += dc[dir];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) break;

                if (food[nr][nc] == origFood) continue; // 같은 음식이면 그냥 통과

                int y = belief[nr][nc];
                if (x > y) {
                    // 강한 전파
                    belief[nr][nc] = y + 1;
                    food[nr][nc] = origFood;
                    defended[nr][nc] = true;
                    x -= (y + 1);
                } else {
                    // 약한 전파
                    food[nr][nc] |= origFood;
                    belief[nr][nc] += x;
                    defended[nr][nc] = true;
                    x = 0;
                }
            }
        }
    }

    String daySummary() {
        long[] sum = new long[8];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                sum[food[i][j]] += belief[i][j];

        return sum[7] + " " + sum[3] + " " + sum[5] + " " + sum[6] + " "
                + sum[4] + " " + sum[2] + " " + sum[1];
    }
}