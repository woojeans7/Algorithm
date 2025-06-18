import java.util.*;
import java.io.*;

/*
    BAEKJOON 14502번 연구소
    https://www.acmicpc.net/problem/14502
*/

public class Main {
  public static void main(String[] args) throws IOException {
    // 벽을 세운다
    // 바이러스를 퍼트려본다
    // 0의 개수를 구한다
    // -> 이 값을 max값과 계속 비교하면서 최대값을 구한다
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());

    map = new int[x][y];

    for(int i = 0; i < x; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < y; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0);

    System.out.println(max);
  }

  public static int x;
  public static int y;
  public static int[][] map;
  public static int max = 0;

  // 모든 경우의 수를 찾아야 하니까 완전탐색 재귀를 사용
  public static void dfs(int index){
    if(index == 3){
      // 바이러스를 퍼트려본다.
      // 남아있는 0의 개수를 센다
      int ans = bfs();
      // max = Math.max(max, 0의 개수) -> 최대값 구하기
      max = Math.max(max, ans);
      return;
    }

    for(int i = 0; i < x; i++){
      for(int j = 0; j < y; j++){
        if(map[i][j] == 0){
          map[i][j] = 1;
          dfs(index+1);
          map[i][j] = 0;
        }
      }
    }
  }

  // 바이러스를 퍼뜨리기 위한 bfs
  public static int bfs(){
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[x][y];

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    for(int i = 0; i < x; i++){
      for(int j = 0; j < y; j++){
        if(map[i][j] == 2){
          queue.add(new int[] {i, j});
        }
      }
    }

    while(!queue.isEmpty()){
      int[] cur = queue.poll();
      int r = cur[0];
      int c = cur[1];

      for(int i = 0; i < 4; i++){
        int nr = r + dr[i];
        int nc = c + dc[i];
        if(nr >= 0 && nr < x && nc >= 0 && nc < y){
          if(!visited[nr][nc] && map[nr][nc] == 0){
            queue.add(new int[] {nr, nc});
            visited[nr][nc] = true;
          }
        }
      }
    }

    // 안전 영역의 갯수 구하기
    // 0이면서 바이러스가 들리지 않은 곳
    int count = 0;
    for(int i = 0; i < x; i++){
      for(int j = 0; j < y; j++){
        if(map[i][j] == 0 && !visited[i][j]){
          count++;
        }
      }
    }
    return count;
  }
}
