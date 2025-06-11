import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] challengers = new int[N+2];
        
        // 스테이지 별 도전자 수
        for(int stage : stages){
            challengers[stage] += 1; 
        }
        
        Map<Integer, Double> map = new HashMap<>();
        
        double arrived = stages.length;
        
        for(int i = 1; i <= N; i++){
            if(challengers[i] == 0){
                map.put(i, 0.);
            }
            else{        
                // 실패율 계산   
                map.put(i, challengers[i] / arrived);
                arrived -= challengers[i];
            }
        }
         // value 기준 내림차순 정렬 후 key만 추출
        List<Integer> sortedKeys = map.entrySet()
            .stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        // 리스트를 int[] 배열로 변환
        int[] result = sortedKeys.stream().mapToInt(Integer::intValue).toArray();

        
       
        return result;
    }
}