import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    Queue<int[]> q = new LinkedList<>();
    int[] dx = {-1, 1};
    boolean[] visited = new boolean[100001];
    visited[n] = true;
    q.add(new int[]{n, 0});

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int x = cur[0];
      int dist = cur[1];

      if (x == m) {
        System.out.println(dist);
        break;
      }

      for(int i = 0; i < 2; i++){
        int nx = x + dx[i];
        if(nx >= 0 && nx <= 100000 && !visited[nx]){
          q.add(new int[]{nx, dist + 1});
          visited[nx] = true;
        }
      }
      int nx = 2 * x;
      if(nx >= 0 && nx <= 100000 && !visited[nx]){
        q.add(new int[]{nx, dist + 1});
        visited[nx] = true;
      }
    }
  }
}
