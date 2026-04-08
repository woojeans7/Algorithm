import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
		    //✅ participant와 completion을 비내림차순으로 정렬한다.
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        //✅ i를 0 ~ completion.length까지 순회한다. 
        for (int i = 0; i < completion.length; i++) {
        		//✅ participant와 completion이 다르면 반환한다.
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        
        //✅ 마지막 인덱스까지 확인해도 정답이 나오지 않았다면 마지막 participant를 반환한다.
        return participant[participant.length - 1];
    }
}