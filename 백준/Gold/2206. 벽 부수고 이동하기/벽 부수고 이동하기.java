import java.util.*;
import java.io.*;

/*
    BAEKJOON 2206번 벽 부수고 이동하기
    https://www.acmicpc.net/problem/2206
*/

public class Main {
  public static void main(String[] args) throws IOException {
    // 입력 설정
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 분리해서 입력받기 위함 (띄어쓰기)
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // n * m 맵 저장
    int[][] map = new int[n][m];

    // 나머지 한 줄씩 n번 입력 받음
    for (int i = 0; i < n; i++) {
      // 1000 -> [1,0,0,0] 배열로 분리하기 위한 작업
      String[] tokens = br.readLine().split("");
      // 정수로 변환해서 저장
      for(int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(tokens[j]);
      }
    }

    int answer = bfs(n,m,map);
    System.out.println(answer);
    // 출력 디버깅
    //System.out.println(Arrays.deepToString(map));

  }
  private static int bfs(int n, int m, int[][] map) {
    Queue<int[]> queue = new ArrayDeque<>();
    boolean[][][] visited = new boolean[n][m][2];

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    // r, c, dist, 부수기 여부
    queue.offer(new int[] {0,0,1,0});
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
          if(map[nr][nc] == 0 && !visited[nr][nc][broken]) {
            queue.offer(new int[]{nr, nc, dist + 1, broken});
            visited[nr][nc][broken] = true;
          }
          else if(map[nr][nc] == 1 && broken == 0 && !visited[nr][nc][broken+1]) {
            queue.offer(new int[]{nr, nc, dist + 1, broken+1});
            visited[nr][nc][broken+1] = true;
          }
        }
      }
    }
    return -1;
  }
}
