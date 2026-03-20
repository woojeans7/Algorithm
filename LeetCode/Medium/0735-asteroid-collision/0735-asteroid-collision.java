class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        // 모든 소행성 탐색
        for(int asteroid : asteroids) {
            // 소행성 값이 양수인 경우(= 오른쪽으로 움직이는 소행성)
            if(asteroid > 0) {
                // stack에 값 추가
                stack.push(asteroid);
            }
            // 소행성 값이 음수인 경우(= 왼쪽으로 움직이는 소행성)
            else {
                // stack에 비교할 양수 값이 남아있고
                // stack의 가장 위에 있는 소행성의 크기보다 작아질 때까지 소행성 파괴
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                    stack.pop();
                }
                // 더 이상 stack에 비교할 양수 값이 남아있지 않은 경우
                if(stack.isEmpty() || stack.peek() < 0) {
                    // stack에 값 추가
                    stack.push(asteroid);
                }
                // 비교할 두 소행성의 사이즈가 같은 경우
                else if(stack.peek() == -asteroid) {
                    // 두 소행성 모두 파괴
                    stack.pop();
                }
            }
        }
        
        // Array 형태로 return
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

}