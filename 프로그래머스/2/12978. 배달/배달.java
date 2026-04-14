import java.util.*;

class Edge{
    int to;
    int dist;
    
    public Edge(int to, int dist){
        this.to = to;
        this.dist = dist;
    }
}
class Solution {
    public int solution(int N, int[][] road, int K) {
        final int INF = Integer.MAX_VALUE;

        List<List<Edge>> town = new ArrayList<>();
        
        for(int i=0; i <= N; i++){
            town.add(new ArrayList<>());
        }
        
        for(int[] r : road){
            town.get(r[0]).add(new Edge(r[1], r[2]));
            town.get(r[1]).add(new Edge(r[0], r[2]));
        }
        
        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF);
        
        
        Queue<Edge> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.dist, b.dist));
        pq.add(new Edge(1, 0));
        distance[1] = 0;
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            
            if(distance[cur.to] < cur.dist) continue;
            
            for(Edge edge : town.get(cur.to)){
                int newDist = cur.dist + edge.dist;
                if(newDist < distance[edge.to]){
                    distance[edge.to] = newDist;
                    pq.add(new Edge(edge.to, newDist));
                }
            }
        }
        
        int answer = 0;
        for(int i = 1; i <= N; i++){
            if(distance[i] <= K) answer++;
        }
        
        return answer;
        
    }
}