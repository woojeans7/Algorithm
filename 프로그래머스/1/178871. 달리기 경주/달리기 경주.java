import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }

        for(String calling : callings){
            int idx = map.get(calling);
            String prev = players[idx - 1];

            players[idx - 1] = calling;
            players[idx] = prev;

            map.put(calling, idx - 1);
            map.put(prev, idx);
        }

        return players;
    }
}