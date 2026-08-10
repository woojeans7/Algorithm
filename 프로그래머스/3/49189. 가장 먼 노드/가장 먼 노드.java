import java.util.*;

class Solution {
    public int solution(int n, int[][] edges) {
        int[] distance = new int[n + 1];

        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        int answer = 0;
        int max = 0;
        bfs(graph, distance, 1);

        for (int i = 1; i <= n; i++) {
            if (distance[i] > max) {
                max = distance[i];
                answer = 1;
            } else if (distance[i] == max) {
                answer++;
            }
        }

        return answer;
    }

    void bfs(List<Integer>[] graph, int[] distance, int start){
        Queue<Integer> q = new LinkedList<>();

        Arrays.fill(distance, -1);

        q.offer(start);
        distance[start] = 0;

        while(!q.isEmpty()){
            int current = q.poll();
            for (int next : graph[current]) {
                if (distance[next] == -1) {
                    q.offer(next);
                    distance[next] = distance[current] + 1;
                }
            }
        }
    }
}