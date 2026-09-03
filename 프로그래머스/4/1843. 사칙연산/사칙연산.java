import java.util.*;

class Solution {
    public int solution(String[] arr) {
        int n = arr.length / 2 + 1;
        int INF = Integer.MAX_VALUE;

        int[] nums = new int[n];
        char[] operators = new char[n-1];

        for(int i = 0; i < arr.length; i++){
            if(i % 2 == 0){
                nums[i/2] = Integer.parseInt(arr[i]);
            }
            else operators[i/2] = arr[i].charAt(0);
        }

        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(maxDp[i], -INF);
            Arrays.fill(minDp[i], INF);
        }

        for(int i = 0; i < n; i++){
            minDp[i][i] = nums[i];
            maxDp[i][i] = nums[i];
        }

        for(int step = 0; step < n; step++){
            for(int i = 0; i < n-step; i++){
                int j = step + i;

                for(int k = i; k < j; k++){
                    if(operators[k] == '+'){
                        maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] + maxDp[k+1][j]);
                        minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] + minDp[k+1][j]);
                    }
                    else{
                        maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] - minDp[k+1][j]);
                        minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] - maxDp[k+1][j]);
                    }
                }
            }
        }

        return maxDp[0][n-1];
    }
}