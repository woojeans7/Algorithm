import java.util.*;

class Solution {
    
    class Edge{
        public int node;
        public int cost;
        
        public Edge(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    
    final int INF = Integer.MAX_VALUE;
    
    public int solution(int N, int[][] road, int K) {
        
        // 그래프 구현
        List<List<Edge>> town = new ArrayList<>();
        
        for(int i = 0; i <= N; i++){
            town.add(new ArrayList<>());
        }
        
        for(int[] r : road){
            int u = r[0];
            int v = r[1];
            int weight = r[2];
            
            town.get(u).add(new Edge(v, weight));
            town.get(v).add(new Edge(u, weight));
        }
        
        // 다익스트라 실행
        int[] distance = dijkstra(town, N, K);
        
        int answer = 0;
        for(int i = 1; i <= N; i++){
            // 걸리는 시간이 K시간 이하일 경우 +1
            if(distance[i] <= K) answer++;
        }
        
        
        return answer;
    }
    
    // 다익스트라 구현
    private int[] dijkstra(List<List<Edge>> town, int n, int k){
        
        int[] distance = new int[n+1];
        Arrays.fill(distance, INF);
        
        // 시작점 예약  
        Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));  
        pq.add(new Edge(1, 0));  
        distance[1] = 0;  
        
        while(!pq.isEmpty()){
            // 방문
            Edge cur = pq.remove();
            
            if(distance[cur.node] < cur.cost) continue;
            
            for(Edge next : town.get(cur.node)){
                int newDist = distance[cur.node] + next.cost;  
                if (newDist < distance[next.node]) {  
                    pq.add(new Edge(next.node, newDist));  
                    distance[next.node] = newDist;  
                }
            }
        }
        
        return distance;
    }
}