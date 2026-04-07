import java.util.*;

class Solution {
    private class Word{
        String word;
        int count;    
        // 생성자
        Word(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        Queue<Word> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        
        // bfs 탐색
        // 시작점 예약
        queue.add(new Word(begin, 0));
        while(!queue.isEmpty()){
            Word cur = queue.poll();
            
            // target에 도달하면 카운트 반환
            if(cur.word.equals(target)) return cur.count;
            
            // 몇 번 반환했는지 체크   
            for(int n=0; n< words.length; n++){
                if(!visited[n] && getDiff(cur.word, words[n])){
                    queue.add(new Word(words[n], cur.count + 1));
                    visited[n] = true;
                }    
            }
             
        }

        return 0;
    }
    // 단어 수 차이가 1개인지 체크하는 메서드
    private boolean getDiff(String s1, String s2){
        // 단어 크기만큼 반복문
        int cnt = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                cnt++;
            }
        }
        if(cnt == 1) return true;
        return false;
    }
}