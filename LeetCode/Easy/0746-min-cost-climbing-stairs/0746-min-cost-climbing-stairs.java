import java.util.*;

class Solution {
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        return recursive(cost, n);
    }

    // n층까지 가는 최소 비용이 리턴되는 마법의 함수
    private int recursive(int[] cost, int n){

        if(n == 0 || n == 1) return 0; // 시작점이 0, 1이니까 출발할 때 비용은 0

        if(memo[n] == -1){
            memo[n] = Math.min(recursive(cost, n-1) + cost[n-1], recursive(cost, n-2) + cost[n-2]);
        }
        
        return memo[n];
    }
}