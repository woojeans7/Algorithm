import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // 참가자 이름과 등장 횟수를 담은 해시맵 저장
        Map<String, Integer> map = new HashMap<>();

        // 참가자 이름과 기본값을 0으로 +1을 해준다. - 동명이인일 경우 조회된 값 +1
        for(String p : participant){
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        // 완주자 목록 안에 존재하면 -1 횟수 차감
        for(String s : completion){
            map.put(s, map.get(s) - 1);
        }

        // 0이 아닌 이름이 완주하지 못한 선수
        for(String key : map.keySet()){
            if(map.get(key) != 0){
                answer = key;
                break;
            }
        }

        return answer;
    }
}