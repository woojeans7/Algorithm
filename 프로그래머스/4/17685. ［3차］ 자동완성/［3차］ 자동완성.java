import java.util.*;

class Solution {
    public int solution(String[] words) {
        int answer = 0;
        Arrays.sort(words);
        
        int[] counts = new int[words.length];
        
        for(int i = 0; i < words.length - 1; i++){
            String pre = words[i];
            String next = words[i+1];
            int len = Math.min(pre.length(), next.length());
            
            int sameCount = getSamecount(pre, next, len);
            
            if(sameCount == len){
                counts[i] = Math.max(counts[i], sameCount);
            }
            else{
                counts[i] = Math.max(counts[i], sameCount+1);
            }
            counts[i+1] = Math.max(counts[i+1], sameCount+1);
        }
        for(int c : counts){
            answer += c;
        }
        return answer;
    }
    
    static int getSamecount(String pre, String next, int len){
        int cnt = 0;
        
        for(int i = 0; i < len; i++){
            if(pre.charAt(i) != next.charAt(i)) return cnt;
            cnt++;
        }
        return cnt;
    }
}