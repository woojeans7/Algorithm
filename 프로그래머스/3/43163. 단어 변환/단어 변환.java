import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        List<String> wordList = Arrays.asList(words);  // words안에서 단어를 바로 찾기 위해 리스트로 변환
        if (!wordList.contains(target)) {
            answer = 0;
        }

        visited = new boolean[words.length];

        dfs(begin, target, words, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    // s1에서 s2로 변환할 수 있는지 체크
    public boolean canChange(String s1, String s2) {
        int diff =0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (++diff > 1) return false;  // 2글자 이상 다르면 조기 종료
            }
        }

        return diff == 1;
    }

    public void dfs(String begin, String target, String[] words, int cnt) {
        // target과 동일해졌다면
        if(begin.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }

        // 모든 단어에 대해 탐색
        for (int i = 0; i < words.length; i++) {
            // 이미 방문한 단어는 스킵
            if (visited[i]) {
                continue;
            }

            // 한 글자만 다른 단어 dfs 실행
            if(canChange(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, cnt+1); // 변환횟수도 카운트
                visited[i] = false; // 백트래킹
            }
        }
    }
}
