import java.util.*;

class Assignment{
    String name;
    int duration;

    public Assignment(String name, int duration){
        this.name = name;
        this.duration = duration;
    }
}

class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();

        // 1. 시간을 분단위로 변경
        for(String[] plan : plans){
            String[] start = plan[1].split(":");
            plan[1] = String.valueOf(Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]));
        }

        // 2. 시간 순으로 정렬
        Arrays.sort(plans, Comparator.comparing(p -> Integer.parseInt(p[1])));

        // 3. 남은 과제를 담을 스택 선언
        Deque<Assignment> stack = new ArrayDeque<>();

        // 4. 모든 과제 처리
        for(int i = 0; i < plans.length - 1; i++){
            String name = plans[i][0];
            int start = Integer.parseInt(plans[i][1]);
            int duration = Integer.parseInt(plans[i][2]);

            // 다음 과제 시간까지 끝낼 수 있나?
            int next = Integer.parseInt(plans[i+1][1]);

            int difference = next - start;

            // 시간이 남으면 완료
            if(difference >= duration){
                answer.add(name);

                // 과제하고 나서 남는 시간 계산
                int remain = difference - duration;

                // 밀린 과제가 있다면
                while(!stack.isEmpty() && remain > 0){
                    Assignment prev = stack.pop();
                    if(remain >= prev.duration){
                        answer.add(prev.name);
                        remain -= prev.duration;
                    }
                    else{
                        stack.push(new Assignment(prev.name, prev.duration - remain));
                        break;
                    }
                }
            }
            else{
                stack.push(new Assignment(name, duration - difference));
            }
        }

        // 마지막 과목을 처리
        answer.add(plans[plans.length - 1][0]);

        // 밀린 모든 과목 역순으로 처리
        while(!stack.isEmpty()){
            answer.add(stack.pop().name);
        }

        return answer.toArray(new String[0]);
    }
}