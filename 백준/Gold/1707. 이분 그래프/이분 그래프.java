import java.io.*;
import java.util.*;

public class Main {
  static ArrayList<Integer>[] arr;
  static int[] check;
  static boolean[] visited;
  static boolean IsEven;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCase = Integer.parseInt(br.readLine());

    for (int i = 0; i < testCase; i++) { // 주어진 테스트케이스만큼 돌림
      // 초기화
      String[] s = br.readLine().split(" ");
      int v = Integer.parseInt(s[0]);
      int e = Integer.parseInt(s[1]);
      arr = new ArrayList[v+1]; // 노드가 1번부터 시작하기 때문에
      visited = new boolean[v+1];
      check = new int[v+1];
      IsEven = true;

      for (int j = 1; j <= v; j++) {
        arr[j] = new ArrayList<Integer>();
      }

      // edge 데이터 저장하기
      for(int k = 0; k<e; k++){
        s = br.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        int end = Integer.parseInt(s[1]);
        arr[start].add(end);
        arr[end].add(start);
      }

      // 모든 노드에서 DFS 실행해야 함.
      for (int j = 1; j <= v; j++) {
        if(IsEven){
          dfs(j);
        }
        else{
          break;
        }
      }
      if(IsEven){
        System.out.println("YES");
      }
      else{
        System.out.println("NO");
      }
    }
  }
  private static void dfs(int startVertex){
    visited[startVertex] = true;
    for(int nextVertex : arr[startVertex]){ // 인접리스트로 받아서 startVertex에서 연결된 모드 노드를 불러옴
      if(!visited[nextVertex]){
        // 바로 직전에 있는 노드와 다른 집합으로 분류를 해주는 것이 필요함
        check[nextVertex] = (check[startVertex] + 1) % 2;
        dfs(nextVertex);
      }
      else if(check[startVertex] == check[nextVertex]){
        IsEven = false;
      }
    }
  }
}
