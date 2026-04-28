import java.util.*;

public class Solution {
    private int max;
    private int[] answer;
    private int[] apeach;

    public int[] solution(int n, int[] info) {
        apeach = info;
        max = 0;
        backtrack(n, 0, new int[11]);
        return max == 0 ? new int[]{-1} : answer;
    }

    private void backtrack(int n, int idx, int[] ryan) {
        if (n == 0) {
            int score = 0;
            for (int i = 0; i <= 10; i++) {
                if (ryan[i] + apeach[i] > 0)
                    score += ryan[i] > apeach[i] ? (10 - i) : -(10 - i);
            }
            if (max < score) {
                max = score;
                answer = ryan.clone();
            } else if (max > 0 && max == score) {
                for (int i = 10; i >= 0; i--) {
                    if (answer[i] != ryan[i]) {
                        if (answer[i] < ryan[i]) answer = ryan.clone();
                        break;
                    }
                }
            }
            return;
        }
        for (int i = idx; i <= 10; i++) {
            int cnt = i == 10 ? n : apeach[i] + 1;
            if (cnt > n) continue;
            ryan[i] = cnt;
            backtrack(n - cnt, i + 1, ryan);
            ryan[i] = 0;
        }
    }
}