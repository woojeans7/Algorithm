import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        Map<Integer, Integer> color = new HashMap<>();

				// 모든 노드에 대한 검사
        for (int i = 0; i < n; i++) {
		        // 방문한 적이 없는 노드라면 DFS 실행
            if (!color.containsKey(i)) {
                if (!dfs(graph, color, i, 0)) {
                    return false;
                }
            }
        }

        return true;
    }

		// true, false를 반환하기 위해서 dfs 메서드를 boolean타입으로 지정
    public boolean dfs(int[][] graph, Map<Integer, Integer> color, int startVertex, int currentColor) {
        // 시작 노드 초기화
        color.put(startVertex, currentColor);

        for (int next : graph[startVertex]) {
			      // 인접 노드 미 방문 시
            if (!color.containsKey(next)) {
                // 인접노드는 다른 색으로 지정
                if (!dfs(graph, color, next, 1 - currentColor)) {
                    return false; // 색이 겹치면 false 반환
                }
            } else if (color.get(next) == currentColor) {
                return false; // 칠해져있는 색상이 현재 색상과 동일해도 false 반환
            }
        }

        return true; // 
    }
}
