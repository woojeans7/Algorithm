import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int[] info, int[][] edges) {
        // 루트에서 출발해서 양을 모으려고 함
        // 늑대도 있음. 양의 마리 수 <= 늑대의 수라면 잡아먹힘
        // 최대한 많은 양을 모으는게 목표
        int n = info.length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
        }

        List<Integer> newNext = new ArrayList<>();
        newNext.add(info[0]);

        dfs(0, 0, 0, graph, info, newNext);

        return answer;
    }
    private void dfs(int cur, int sheep, int wolf, List<List<Integer>> graph, int[] info, List<Integer> newNext){
        // 현재 노드가 양이면
        if(info[cur] == 0) sheep += 1;
        else wolf += 1;

        // 양, 늑대의 조건에 따라 종료
        if(sheep <= wolf) return;

        // 최대 양의 수
        answer = Math.max(answer, sheep);

        // 현재 노드를 탐색에서 제외
        newNext.remove(Integer.valueOf(cur));
        for(int next : graph.get(cur)){
            newNext.add(next);
        }

        for(int next : newNext){
            dfs(next, sheep, wolf, graph, info, new ArrayList<>(newNext));
        }
    }
}