import java.util.*;

class Solution {
    public int solution(int n, int[][] edges) {
        int[] distance = new int[n];
        // 인접 리스트 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>()); // 각 노드에 대해 빈 리스트 추가
        }

        // 양방향 간선 추가
        for (int[] edge : edges) {
            int a = edge[0] -1;
            int b = edge[1] -1;

            graph.get(a).add(b); // a -> b 연결
            graph.get(b).add(a); // b -> a 연결 (양방향)
        }
        
        int answer = 0;
        int max = 0;
        bfs(graph,distance, 0);
        for(int d : distance){
            if(d > max){
                answer = 1;
                max = d;
            }
            else if(d == max){
                answer++;
            }
        }
        return answer;
    }
    
    void bfs(List<List<Integer>> graph,int[] distance, int start){
        Queue<Integer> q = new LinkedList<>();
        
        Arrays.fill(distance, -1);
        
        q.add(start);
        distance[start] = 0;   
        
        while(!q.isEmpty()){
            int current = q.remove();
            for (int next : graph.get(current)) {
                if (distance[next] == -1) {
                    q.add(next);
                    distance[next] = distance[current] + 1;
                }
            }
        }
        
    }
}