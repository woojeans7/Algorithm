import java.util.*;

class Solution {
    public int[] solution(String[] gems) {

        Set<String> types = new HashSet<>(Arrays.asList(gems));
        int gemSize = types.size();

        Map<String, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int index = 0;
        // 구간의 길이가 가장 짧아야 함
        // 보석의 종류가 모두 포함되어야 함.
        while(end < gems.length){
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            end++;

            while(map.size() == gemSize){
                if(end - start < minLen){
                    minLen = end - start;
                    index = start;
                }

                map.put(gems[start], map.get(gems[start]) -1);
                if(map.get(gems[start]) == 0){
                    map.remove(gems[start]);
                }
                start++;
            }
        }

        return new int[]{index + 1, index + minLen};
    }
}