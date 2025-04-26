import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); // 노드 개수
    int m = sc.nextInt(); // 엣지 개수

    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      // 1번 노드를 인덱스 0번에 저장하기 위해 -1
      int u = sc.nextInt() - 1; 
      int v = sc.nextInt() - 1;
      // 양방향 그래프 추가
      graph.get(u).add(v);
      graph.get(v).add(u); 
    }

    int cnt = 0; // 연결 요소 카운팅
    boolean[] visited = new boolean[n]; // 노드의 방문을 저장할 배열
    // dfs가 실행한다면 다른 네트워크임
    for (int i = 0; i < n; i++) {
      if(!visited[i]){
        dfs(graph, visited, i);
        cnt++;
      }
    }

    System.out.println(cnt); // 연결 요소의 개수 출력
  }

  public static void dfs(List<List<Integer>> graph, boolean[] visited, int current) {
    visited[current] = true;

    for (int nextVertex : graph.get(current)) {
      if (!visited[nextVertex]) {
        dfs(graph, visited, nextVertex);
      }
    }
  }
}
