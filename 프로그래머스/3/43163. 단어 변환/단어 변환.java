import java.util.Arrays;

class Solution {
    int answer = Integer.MAX_VALUE;
    boolean[] visited;
    int n;

    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0;

        n = words.length;
        visited = new boolean[n];

        dfs(begin, target, words, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    public void dfs(String current, String target, String[] words, int depth) {
        if (current.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && canConvert(current, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, depth + 1);
                visited[i] = false; // 백트래킹
            }
        }
    }

    public boolean canConvert(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 1;
    }
}

