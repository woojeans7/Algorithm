import java.util.*;

class Solution {
    class WhoReport {
        List<String> rplist = new ArrayList<>();
        int count;
        
        WhoReport(List<String> rplist, int count){
            this.rplist = rplist;
            this.count = count;
        }
    }
    public int[] solution(String[] id_list, String[] report, int k) {
        // 해시맵으로 초기화
        Map<String, WhoReport> map = new HashMap<>();
        
        // report 분리
        for(String s : report){
            String[] rp = s.split(" ");
            List<String> rpuser = new ArrayList<>();
            // 해시맵에 user id저장
            for (String id : id_list){
                map.putIfAbsent(id, new WhoReport(new ArrayList<>(), 0));
            }
            // 해시맵에 user별 신고자, 신고 받은 횟수 저장
            map.putIfAbsent(rp[0], new WhoReport(new ArrayList<>(), 0));
            if(map.get(rp[0]).rplist.contains(rp[1])) continue;
            map.get(rp[0]).rplist.add(rp[1]);
        }
        // 신고 받은 횟수 카운트
        for(String id : id_list){
            for(WhoReport r : map.values()){
                if(r.rplist.contains(id)){
                     map.get(id).count += 1;
                }
            }
        }
        
        // 정지 유저 저장
        List<String> ban = new ArrayList<>();
        for(int i = 0; i < id_list.length; i++){
            if(map.get(id_list[i]).count >= k){
                ban.add(id_list[i]);
            }
        }
        // 결과 저장
        int[] result = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++){
            int mail = 0;
            for(String b : ban){
                if(map.get(id_list[i]).rplist.contains(b))
                    mail++;
            }
            result[i] = mail;
        }
        
        return result;
    }
}