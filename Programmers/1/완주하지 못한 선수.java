import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++){
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        for (int j =0; j < completion.length; j++){
            map.put(completion[j], map.get(completion[j]) - 1);
        }
        
        for (String key : map.keySet()) {
        if (map.get(key) != 0) {
            answer = key;
            break;
        }
    }
        return answer;
    }
}