import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        // 유저 아이디 - 닉네임 매핑
        Map<String, String> map = new HashMap<>();
        
        // 결과 저장
        List<String> result = new ArrayList<>();
        
        int n = record.length;
        String[][] command = new String[n][3];
        for(int i = 0; i < n; i++){
            command[i] = record[i].split(" ");
        }
        
        // 순회 시작
        for(int i = 0;  i < n; i++){
            String keyword = command[i][0];
            String user = command[i][1];
            String nickname = command[i].length > 2 ? command[i][2] : null;
            
            actions(keyword, map, user, nickname);
            print(keyword, user, result);
        }
        
        List<String> answer = new ArrayList<>();
        for(String res : result){
            String[] part = res.split(" ", 2);
            String uid = part[0];
            String action = part[1];
            answer.add(map.get(uid) + action);
        }
        
        return answer.toArray(String[]::new);
    }
    private void actions(String keyword, Map<String, String> map, String user, String nickname){
        if(keyword.equals("Enter") || keyword.equals("Change")){
            map.put(user, nickname);
        }
    }
    private void print(String keyword, String user, List<String> result){
        if(keyword.equals("Enter")){
            StringBuilder sb = new StringBuilder();
            sb.append(user).append(" 님이 들어왔습니다.");
            result.add(sb.toString());
        }
        else if(keyword.equals("Leave")){
            StringBuilder sb = new StringBuilder();
            sb.append(user).append(" 님이 나갔습니다.");
            result.add(sb.toString());
        }
    }
}