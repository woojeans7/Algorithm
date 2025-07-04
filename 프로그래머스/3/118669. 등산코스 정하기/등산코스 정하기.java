import java.util.*;

class Solution {
    class Edge{
        int node, cost;
        Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // 인접리스트 초기화
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            int u = path[0];
            int v = path[1];
            int w = path[2];
            
            graph.get(u).add(new Edge(v,w));
            graph.get(v).add(new Edge(u,w));
        }
        
        // 게이트와 산봉우리 표시
        boolean[] isGate = new boolean[n + 1];
        boolean[] isSummit = new boolean[n + 1];
        for (int g : gates) isGate[g] = true;
        for (int s : summits) isSummit[s] = true;

        // intensity 저장할 배열
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));

        // 시작점 모두 저장
        for (int g : gates) {
            pq.offer(new Edge(g, 0));
            intensity[g] = 0;
        }

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int node = cur.node, curIntensity = cur.cost;

            // 현재 저장값보다 크면 업데이트 X
            if (intensity[node] < curIntensity) continue;
            // 산봉우리에 도달하면 스킵
            if (isSummit[node]) continue;

            // 다음 노드 예약
            for (Edge next : graph.get(node)) {
                int nextNode = next.node;
                int cost = next.cost;
                // 이동시간이 더 큰 값으로 갱신함. -> 경로 중 가장 긴 시간이 intensity
                int newIntensity = Math.max(curIntensity, cost);

                // intensity에 있는 값보다 작고, 시작점이 아닐 때 업데이트
                if (intensity[nextNode] > newIntensity && !isGate[nextNode]) {
                    pq.offer(new Edge(nextNode, newIntensity));
                    intensity[nextNode] = newIntensity;
                }
            }
        }

        // 정답 봉우리와 최소값을 초기화
        int answerSummit = 0, minIntensity = Integer.MAX_VALUE;
        Arrays.sort(summits);

        // 산봉우리 중 가장 작은 intensity를 찾고 정답에 저장
        for (int s : summits) {
            if (intensity[s] < minIntensity) {
                minIntensity = intensity[s];
                answerSummit = s;
            }
        }

        return new int[]{answerSummit, minIntensity};
    }
}
