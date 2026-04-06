import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // 해시맵에 가장 장르별로 총합을 구함 classic : 3100, pop : 1450
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < plays.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // value순으로 장르를 내림차순 정렬
        List<String> genreList = new ArrayList<>(map.keySet());
        genreList.sort((a,b) -> map.get(b) - map.get(a));
        
        List<Integer> answer = new ArrayList<>();
        
        // 2개만 반복
        for(int i = 0; i < genreList.size(); i++){
            String cur = genreList.get(i);
            // 각 장르에서 내림차순으로 두 개만 추출
            List<int[]> albums = new ArrayList<>();
            for(int j = 0; j < plays.length; j++){
                if(genres[j].equals(cur)){
                    albums.add(new int[]{j, plays[j]});
                }
            }
            // 재생 횟수가 같다면 고유번호 낮은게 우선
            albums.sort((a, b) -> b[1] != a[1] ? b[1] - a[1] : a[0] - b[0]);
            
            for(int j = 0; j < Math.min(2, albums.size()); j++){
                answer.add(albums.get(j)[0]);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}