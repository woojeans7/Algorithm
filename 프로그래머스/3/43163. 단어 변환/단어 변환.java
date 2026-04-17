import java.util.*;

class State{
    String word;
    int cnt;
    
    public State(String word, int cnt){
        this.word = word;
        this.cnt = cnt;
    }
}
class Solution {
    public int solution(String begin, String target, String[] words) {
        
        Queue<State> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        queue.offer(new State(begin, 0));
        
        while(!queue.isEmpty()){
            State cur = queue.poll();
            
            if(cur.word.equals(target)) return cur.cnt;
            
            for(int i = 0; i < words.length; i++){
                String next = words[i];
                
                if(!visited[i] && getDiff(cur.word, next)){
                    visited[i] = true;
                    queue.offer(new State(next, cur.cnt + 1));
                }
            }
        }
        
        return 0;
    }
    private boolean getDiff(String word1, String word2){
        int count = 0;
        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)) count++;
        }
        
        if(count == 1) return true;
        
        return false;
    }
}