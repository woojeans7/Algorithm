import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[][] map = new int[n][m];

    for (int i = 0; i < n; i++) {
      String[] tokens = br.readLine().split("");
      for(int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(tokens[j]);
      }
    }

    int answer = bfs(n,m,k,map);
    System.out.println(answer);

  }
  private static int bfs(int n, int m, int k, int[][] map) {
    Queue<int[]> queue = new ArrayDeque<>();
    boolean[][][] visited = new boolean[n][m][k+1];

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    // r, c, dist, 부수기 여부
    queue.offer(new int[] {0,0,1,0}); // 시작 지점도 거리에 포함이라 1
    visited[0][0][0] = true;

    while(!queue.isEmpty()) {
      int[] cur = queue.poll();
      int r = cur[0];
      int c = cur[1];
      int dist =  cur[2];
      int broken = cur[3];

      if(r == n-1 && c == m-1) {
        return dist;
      }

      for(int i = 0; i < 4; i++) {
        int nr = r + dr[i];
        int nc = c + dc[i];

        if(nr>=0 && nr < n && nc >=0 && nc < m){
          // 기존 탐색
          if(map[nr][nc] == 0 && !visited[nr][nc][broken]) {
            queue.offer(new int[]{nr, nc, dist + 1, broken});
            visited[nr][nc][broken] = true;
          }
          // 벽을 부술 경우 탐색
          else if(map[nr][nc] == 1 && broken < k && !visited[nr][nc][broken+1]) {
            queue.offer(new int[]{nr, nc, dist + 1, broken+1});
            visited[nr][nc][broken+1] = true;
          }
        }
      }
    }
    return -1;
  }
}
