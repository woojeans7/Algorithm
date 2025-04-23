import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> stack = new LinkedList<>();
        
        stack.push(arr[0]);
        for(int i=0; i<arr.length; i++){
            int current = arr[i];
            if(stack.peek()==current){
                stack.poll();
                stack.push(arr[i]);
            }
            else {stack.push(arr[i]);}
        }
        
        List<Integer> list = new ArrayList<>(stack);
        Collections.reverse(list);
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}