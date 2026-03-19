import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        // 중복 신고 제거
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        
        // 신고 당한 사람 카운팅
        Map<String, Integer> reportCount = new HashMap<>();
        
        // 누가 누구를 신고했는지 저장
        Map<String, List<String>> reportTo = new HashMap<>();

        // 몇 번 신고 당했는지 세기
        for(String r : reportSet){
            String[] parts = r.split(" ");
            String reporter = parts[0];   // 신고자
            String reported = parts[1];   // 피신고자
            
            reportCount.put(reported, reportCount.getOrDefault(reported, 0) + 1);
            reportTo.computeIfAbsent(reporter, key -> new ArrayList<>()).add(reported);
            
        }
    
        // k번 이상인 사람 체크
        int[] answer = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++){
            List<String> reported = reportTo.getOrDefault(id_list[i], new ArrayList<>());
            for(String target : reported){
                if(reportCount.get(target) >= k){
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}