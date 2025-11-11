import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 트리 구현
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for(int i = 1; i <= N; i++){
            tree.put(i, new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree.get(x).add(y);
            tree.get(y).add(x);
        }
        
        // 트리 디버깅
        //System.out.println(tree);
        
        Set<Integer> visited = new HashSet<>(); // 방문 체크
        int[] parent =  new int[N+1]; // 부모 저장

        // 부모 노드 찾는 dfs 함수
        dfs(tree, 1, visited, parent);

        for(int i = 2; i <= N; i++){
            System.out.println(parent[i]);
        }
    }
    private static void dfs(Map<Integer, List<Integer>> tree, int child, Set<Integer> visited, int[] parent) {
        visited.add(child);

        for (int nxt : tree.get(child)) {
            if (!visited.contains(nxt)) {
                parent[nxt] = child;
                dfs(tree, nxt, visited, parent);
            }
        }
    }
}
