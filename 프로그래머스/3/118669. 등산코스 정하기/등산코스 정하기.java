import java.util.*;

class Edge{
    int node; 
    int cost;
    
    public Edge(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
}
class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // n개의 지점 1 ~ n 출입구, 쉼터, 산봉우리
        // 등산로별 소요시간 다름
        // 쉼터, 산봉우리를 방문할 때마다 휴식할 수 있음.
        // 휴식없이 이동해야 하는 시간 중 가장 긴 시간 = intensity
        // 산봉우리는 단 한 곳만 방문해야 함.
        // 출입구 중 한 곳에서 출발해서 산봉우리 한 곳만 방문 후 다시 원래 출입구로 돌아와야 함
        // 처음 - 산봉우리 - 끝 (한 번 씩만 포함하기)
        // 규칙을 지키면서 intensity가 최소가 되도록하는 등산코스를 구하는 문제
        // 최소가 되는 등산코스에 포함된 산봉우리 번호와 최솟값을 반환
        
        // 그래프 초기화
        List<List<Edge>> graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] path : paths){
            int u = path[0];
            int v = path[1];
            int w = path[2];
            
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }
        
        Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        int[] intensities = new int[n + 1];
        Arrays.fill(intensities, 10_000_001);
        
        for(int gate : gates){
            pq.offer(new Edge(gate, 0));
            intensities[gate] = 0;   
        }
        
        Arrays.sort(summits);
        Set<Integer> summitSet = new HashSet<>();
        for(int s : summits){
            summitSet.add(s);
        }

        // 문제점
        // 1. 시작점에서 다시 시작점으로 돌아오는 것
        // 2. 산봉우리를 하나만 방문했다는 것을 어떻게 체크할건지
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            
            if(intensities[cur.node] < cur.cost || summitSet.contains(cur.node)) continue;
            
            for(Edge next : graph.get(cur.node)){
                int newIntensity = Math.max(cur.cost, next.cost);
                
                if(newIntensity < intensities[next.node]){
                    pq.offer(new Edge(next.node, newIntensity));
                    intensities[next.node] = newIntensity;
                }
            }
        }
        
        int[] answer = {0, 10_000_001};
        for(int summit : summits){
            if(answer[1] > intensities[summit]){
                answer[0] = summit;
                answer[1] = intensities[summit];
            }
        }
        return answer;
    }
}