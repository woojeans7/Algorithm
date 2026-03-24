class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int next : asteroids){
            boolean destroyed = false;

            // 충돌 조건 : top이 양수(오른쪽)이고, next가 음수(왼쪽)일 때만
            while(!stack.isEmpty() && stack.peek() > 0 && next < 0){
                int top = stack.peek();

                // 크기 비교 - top은 이미 양수
                if(top < Math.abs(next)){
                    stack.pop(); // top 소행성 파괴
                }
                else if(top == Math.abs(next)){
                    stack.pop();
                    destroyed = true;
                    break;
                }
                else{
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(next);
            }
        }
        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}