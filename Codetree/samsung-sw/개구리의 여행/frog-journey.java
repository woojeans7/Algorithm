import java.io.*;
import java.util.*;

class State{
    int row;
    int col;
    int k;
    int time;

    public State(int row, int col, int k, int time){
        this.row = row;
        this.col = col;
        this.k = k;
        this.time = time;
    }
}
public class Main {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    public int solution(int n, char[][] lake, int r1, int c1, int r2, int c2) {
        final int INF = Integer.MAX_VALUE;
        int[][][] dist = new int[n][n][6];
        for(int[][] layer : dist){
            for(int[] row : layer){
                Arrays.fill(row, INF);
            }
        }
        dist[r1][c1][1] = 0; // 초기 점프력은 1

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.time));
        pq.offer(new State(r1, c1, 1, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int row = cur.row;
            int col = cur.col;
            int k = cur.k;
            int time = cur.time;

            if(time > dist[row][col][k]) continue;

            // 이동 로직
            for(int d = 0; d < 4; d++){
                int nr =  row + dr[d] * k;
                int nc =  col + dc[d] * k;

                if(!isValid(n, nr, nc) || lake[nr][nc] != '.') continue;

                boolean enemy = false;
                for(int i = 1; i < k; i++){
                    int tr = row + dr[d] * i;
                    int tc = col + dc[d] * i;
                    if(lake[tr][tc] == '#') {
                        enemy = true;
                        break;
                    }
                }
                if(enemy) continue;

                int newTime = time + 1;
                if (newTime < dist[nr][nc][k]) {
                    dist[nr][nc][k] = newTime;
                    pq.offer(new State(nr, nc, k, newTime));
                }
            }

            // 점프력 증가 : 비용 (k+1)^2
            if(k < 5){
                int nk = k + 1;
                int newTime = time + nk * nk;
                if (newTime < dist[row][col][nk]) {
                    dist[row][col][nk] = newTime;
                    pq.offer(new State(row, col, nk, newTime));
                }
            }

            // 점프력 감소 : 비용 1, 1~k-1 각각
            for(int nk = 1; nk < k; nk++){
                int newTime = time + 1;
                if(newTime < dist[row][col][nk]) {
                    dist[row][col][nk] = newTime;
                    pq.offer(new State(row, col, nk, newTime));
                }
            }
        }
        int ans = INF;
        for(int k = 1; k <= 5; k++) ans = Math.min(ans, dist[r2][c2][k]);

        return ans == INF ? -1 : ans;
    }
    private boolean isValid(int n, int r, int c){
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();

        int N = Integer.parseInt(br.readLine());
        char[][] A = new char[N][N];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine().toCharArray();
        }

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;

            int answer = main.solution(N, A, r1, c1, r2, c2);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
