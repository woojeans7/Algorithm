import java.util.*;

public class Solution {
    static int maxSheep = 0;

    public int solution(int[] info, int[][] edges) {
        // 1. 트리를 Map으로 구성
        Map<Integer, List<Integer>> tree = new HashMap<>();

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            
            tree.putIfAbsent(parent, new ArrayList<>());
            tree.get(parent).add(child);
        }

        // 2. 탐색 시작
        List<Integer> nexts = new ArrayList<>();
        nexts.add(0);
        
        dfs(0, 0, 0, info, tree, nexts);

        return maxSheep;
    }

    public void dfs(int cur, int sheep, int wolf, int[] info,
                    Map<Integer, List<Integer>> tree, List<Integer> nexts) {

        // 현재 노드가 양인지 늑대인지 확인
        if (info[cur] == 0) sheep++;
        else wolf++;

        // 조건 위반 시 종료
        if (wolf >= sheep) return;

        // 최대 양 수 갱신
        maxSheep = Math.max(maxSheep, sheep);

        // 다음 탐색 후보 구성
        List<Integer> newNexts = new ArrayList<>(nexts);
        newNexts.remove(Integer.valueOf(cur)); // 현재 방문 노드 제거

        if (tree.containsKey(cur)) {
            newNexts.addAll(tree.get(cur)); // 자식 노드 추가
        }

        // 다음 후보 노드들에 대해 DFS
        for (int next : newNexts) {
            dfs(next, sheep, wolf, info, tree, new ArrayList<>(newNexts));
        }
    }
}
