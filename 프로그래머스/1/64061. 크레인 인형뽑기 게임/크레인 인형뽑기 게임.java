import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;


        // 스택을 하나 둬서 pop했을 때 현재 값과 같으면 제거
        Deque<Integer> stack = new ArrayDeque<>();

        // 크레인 횟수만큼 반복 (열 선택)
        for(int move : moves){
            // 인형이 나올 때까지 반복
            int idx = 0;
            while(idx < board.length && board[idx][move - 1] == 0){
                idx++;
            }

            // 인형 없으면 스킵
            if (idx == board.length) continue;

            // 인형이 나오면
            int cur = board[idx][move - 1];
            board[idx][move - 1] = 0;
            
            // 이전 인형과 동일한지 확인
            if(!stack.isEmpty() && stack.peek() == cur){
                stack.pop();
                answer += 2;
            }
            else{
                stack.push(cur);
            }
        }
        return answer;
    }
}