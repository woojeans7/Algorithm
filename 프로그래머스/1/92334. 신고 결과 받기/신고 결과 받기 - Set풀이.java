import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];

        // 중복되는 신고 제거하기
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));

        // 신고 받은 횟수 기록하기
        Map<String, Integer> reportCount = new HashMap<>();

        // 내가 누구를 신고했는지를 기록
        Map<String, List<String>> WhoReport = new HashMap<>();

        for(String s : reportSet){
            String[] parts = s.split(" ");
            String from = parts[0];
            String to = parts[1];

            // 신고 받은 사람이 몇 번 받았는지를 확인
            reportCount.put(to, reportCount.getOrDefault(to,0) + 1);

            // 신고한 사람 추적하기
            if(!WhoReport.containsKey(from)){
                WhoReport.put(from, new ArrayList<>()); // 빈 리스트를 꼭 추가해줘야 함.
            }
            WhoReport.get(from).add(to);
        }

        // K번 이상 신고받은 사람들 찾기
        for(int i = 0; i < n; i++){
            String reporter = id_list[i];
            // 제재 받은 사람을 신고한 사람에게 알려주기 answer[i]++;
            for(String reportee : WhoReport.getOrDefault(reporter, new ArrayList<>())){
                if(reportCount.getOrDefault(reportee, 0) >= k){
                    answer[i] +=1;
                }
            }
        }
        return answer;
    }
}