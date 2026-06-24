import java.util.*;

class Solution {
    public int solution(int[] toppings) {
        int answer = 0;

        Map<Integer, Integer> me = new HashMap<>();
        Map<Integer, Integer> bro = new HashMap<>();

        for(int topping : toppings){
            me.put(topping, me.getOrDefault(topping, 0) + 1);
        }

        for(int topping : toppings){
            me.put(topping, me.get(topping) - 1);
            if(me.get(topping) == 0) me.remove(topping);

            bro.put(topping, bro.getOrDefault(topping, 0) + 1);

            if(bro.size() == me.size()) answer++;

        }
        
        return answer;
    }
}