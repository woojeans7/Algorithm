import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;

        int light = 0;
        int heavy = people.length - 1;
        while(light <= heavy){
            if(people[heavy] + people[light] <= limit) light++;

            
            heavy--;
            answer++;
        }

        return answer;
    }

}