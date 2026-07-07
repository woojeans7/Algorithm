import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if(x == y) return 0;
        // x에 n 더하기
        // x에 2 곱하기
        // x에 3 곱하기
        // x -> y까지 최소 연산 수를 구하는 문제
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(x);
        visited.add(x);
        int count = 0;
        
        while(!queue.isEmpty()){
            count++;
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                int[] next = {cur + n, cur * 2, cur * 3};
                    
                for(int val : next){
                    if(val == y) return count;
                    if(val < y && !visited.contains(val)){
                        queue.add(val);
                        visited.add(val);
                    }
                }
            }
        }
        
        
        
        return -1;
    }
}