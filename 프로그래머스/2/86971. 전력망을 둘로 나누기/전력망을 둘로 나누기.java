import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
    int min = Integer.MAX_VALUE; // 최소값 초기화
    int diff = 0; // 차이를 저장

    // 인접 리스트 초기화
    List<List<Integer>> tree = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
        tree.add(new ArrayList<>());
    }

    // 간선 추가
    for (int[] wire : wires) {
        int a = wire[0];
        int b = wire[1];
        tree.get(a).add(b); // a -> b 연결
        tree.get(b).add(a); // b -> a 연결
    }

    for (int[] wire : wires) {
        int a = wire[0];
        int b = wire[1];

        // 연결 끊기
        tree.get(a).remove((Integer) b); // 객체로 반환
        tree.get(b).remove((Integer) a);

        // 두 그룹의 개수 비교
        boolean[] visited = new boolean[n + 1];
        int group1 = dfs(tree, visited, a);

        visited = new boolean[n + 1]; // 방문배열 초기화
        int group2 = dfs(tree, visited, b);

				diff = Math.abs(group1 - group2);
        min = Math.min(min, diff);

        // 다시 연결
        tree.get(a).add(b);
        tree.get(b).add(a);
    }

    return min;
	}
    
    public static int dfs(List<List<Integer>> tree, boolean[] visited, int curVertex) {
    visited[curVertex] = true;
    int count = 1; // 노드 개수

    for (int nextVertex : tree.get(curVertex)) {
        if (!visited[nextVertex]) {
            count += dfs(tree, visited, nextVertex);
        }
    }

    return count;
	}
}