import java.util.*;

class Solution {
    public int solution(int[] money) {
        // 마을이 동그랗게 배치
        // 인접한 두 집을 털면 경보가 울림
        // 도둑이 훔칠 수 있는 돈의 최댓값을 구하는 문제

        int n = money.length;

        if(n == 1) return money[0];

        // 첫 번째 집을 무조건 포함한 경우
        int[] include =  new int[n];
        // 첫 번째 집을 무조건 배제한 경우
        int[] exclude =  new int[n];

        include[0] = money[0];
        include[1] = Math.max(money[0], money[1]);
        for(int i = 2; i <= n-2; i++){
            include[i] = Math.max(include[i-1], include[i-2] +  money[i]);
        }
        exclude[1] = money[1];
        exclude[2] = Math.max(money[1], money[2]);
        for(int i = 3; i <= n-1; i++){
            exclude[i] = Math.max(exclude[i-1], exclude[i-2] +  money[i]);
        }

        return Math.max(include[n-2], exclude[n-1]);
    }
}