import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
    
        int time = 0;
        if (cacheSize == 0) return 5 * cities.length;
        
        List<String> cache = new LinkedList<>();
        for(String city : cities){
            
            String data = city.toUpperCase();
            int idx = cache.indexOf(data);
            
            // 캐시에 있으면 추가하고 최근 사용 순으로 재배치
            if(idx != -1){
                cache.remove(idx);
                cache.add(data);
                time += 1;
            }
            else{
                if(cache.size() == cacheSize){
                    cache.removeFirst();
                }
                cache.add(data);
                time += 5;
            }  
        } 
        
        return time;
    }
}