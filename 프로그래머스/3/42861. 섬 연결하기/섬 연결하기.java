import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;

        Arrays.sort(costs, Comparator.comparingInt(c -> c[2]));

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for(int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int fee = cost[2];

            // 루트가 다르면 → 연결 (사이클 없음)
            if(find(parent, a) != find(parent, b)){
                union(parent, a, b);
                answer += fee;
            }
            // 루트가 같으면 → 스킵 (사이클 발생)
        }

        return answer;
    }
    // 루트 찾기
    private int find(int[] parent, int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }
    // 연결
    private void union(int[] parent, int a, int b){
        a = find(parent, a);
        b = find(parent, b);
        parent[a] = b;
    }
}