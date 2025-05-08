import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int answer;
    
    // s1에서 s2로 가능한지.
    public boolean canChange(String s1, String s2) {
        int dif_cnt =0;

        for(int i = 0; i < s1.length(); i++){
          if(s1.charAt(i) != s2.charAt(i)){
            dif_cnt++;
          }
        }
        // 다른 문자가 1개일때
        if(dif_cnt == 1){
          return true;
        }
        // 다른문자가 한개가 아닐때
        return false;
    }
             
    public void dfs(String begin, String target, String[] words, int cnt) {
        if(begin.equals(target)) {
            answer = cnt;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            if(canChange(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, cnt+1);
                visited[i] = false;
            }
        }
    }
      
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        
        List<String> wordList = Arrays.asList(words);  // 배열 → 리스트 변환

		    if (!wordList.contains(target)) {
		        answer = 0;
		    }
        
        return answer;
    }
}