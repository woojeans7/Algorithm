import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};

        // n은 참여 사람 수 
        // words에는 순서대로 말한 단어 배열
        // 정답은 말한 사람의 번호, 차례(사람의 순번)
        // 이미 사용한 단어 체크하는 해시셋
        Set<String> usedWords = new HashSet<>();
        // 단어를 추출 끝자리와 다음 단어의 앞자리를 비교 
        char preWord = words[0].charAt(0);
        
        for(int i = 0; i < words.length; i++){
            if(usedWords.contains(words[i]) || words[i].charAt(0) != preWord){
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            // 마지막 단어 추가
            usedWords.add(words[i]);
            // 끝자리로 시작 문자 갱신
            preWord = words[i].charAt(words[i].length() - 1);
        }
        
        return new int[]{0,0};
    }
}