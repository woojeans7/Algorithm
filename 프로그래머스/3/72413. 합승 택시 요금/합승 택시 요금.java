import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int INF = 20_000_000;                       // 오버플로 방지용 (아래 설명)
        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int[] f : fares) {
            dist[f[0]][f[1]] = f[2];
            dist[f[1]][f[0]] = f[2];                // 무방향
        }

        // 플로이드-워셜: 경유지 k가 가장 바깥 루프
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        int answer = INF;
        for (int i = 1; i <= n; i++) {              // i = 합승을 끝내고 갈라지는 지점
            answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
        }
        return answer;
    }
}