import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = {};
        List<String> answerList = new ArrayList<>();
        
        // 1. 시간을 분단위로 변경
        for(String[] plan : plans){
            String[] time = plan[1].split(":");
            int h = Integer.parseInt(time[0]);
            int m = Integer.parseInt(time[1]);
            plan[1] = String.valueOf(h * 60 + m); // 시작시간(분)
            plan[2] = String.valueOf(Integer.parseInt(plan[2])); // 소요시간
        }
        // 2. 시간 순으로 정렬
        Arrays.sort(plans, Comparator.comparingInt(plan -> Integer.parseInt(plan[1])));
        
        // 3. 남은 과제를 담을 스택 선언
        Stack<String[]> stack = new Stack<>();
        
        // 4. 모든 과제 처리
        for(int i = 0; i < plans.length - 1; i++){
            String subject = plans[i][0];
            int startTime = Integer.parseInt(plans[i][1]);
            int duration = Integer.parseInt(plans[i][2]);
            int nextStart = Integer.parseInt(plans[i+1][1]);
            
            // 다음 과제 시간까지 끝낼 수 있나?
            if(startTime + duration <= nextStart){
                answerList.add(subject);
                // 과제하고 나서 남는 시간
                int remainingTime = nextStart - (startTime + duration);
                //이 있고, 밀린 숙제가 있다면
                while(remainingTime > 0 && !stack.isEmpty()){
                    String[] pausedTask = stack.pop();
                    String pausedSubject = pausedTask[0];
                    int pausedDuration = Integer.parseInt(pausedTask[1]);
                    if(remainingTime >= pausedDuration){
                        answerList.add(pausedSubject);
                        remainingTime -= pausedDuration;
                    }
                    else{
                        stack.push(new String[]{pausedSubject, String.valueOf(pausedDuration-remainingTime)});
                        break;
                    }
                }
            }
            else{
                stack.push(new String[]{subject, String.valueOf(duration-(nextStart - startTime))});
            }
        }
        // 마지막 과목을 넣고 남은 모든 과목을 꺼내면서 완료
        stack.push(new String[]{plans[plans.length - 1][0], plans[plans.length - 1][2]});
        
        // 밀린 모든 과목 역순으로 처리
        while(!stack.isEmpty()){
            answerList.add(stack.pop()[0]);
        }
        answer = answerList.toArray(new String[0]);
        
        return answer;
    }
}