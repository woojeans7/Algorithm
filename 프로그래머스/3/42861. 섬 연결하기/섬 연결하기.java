import java.util.*;

class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;

        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        int count = 0;
        for(int[] c : costs){
            int a = c[0];
            int b = c[1];
            int cost = c[2];

            if(find(a) == find(b)) continue;

            union(a, b);
            answer += cost;
        }

        return answer;
    }
    private int find(int v){
        if(parent[v] == v) return v;
        else return parent[v] = find(parent[v]);
    }
    private void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY) parent[rootX] = rootY;
    }
}
