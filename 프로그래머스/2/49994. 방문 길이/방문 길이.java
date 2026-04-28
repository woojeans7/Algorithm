import java.util.*;

class Solution {
    public int solution(String dirs) {
        Map<Character, int[]> location = new HashMap<>();
        initLocation(location);
        int x = 5, y = 5;
        Set<String> result = new HashSet<>();
        
        for(int i = 0; i < dirs.length(); i++){
            int[] offset = location.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];
            
            if(!isValid(nx, ny)) continue;
            
            result.add(x + "," + y + "," + nx + "," + ny);
            result.add(nx + "," + ny + "," + x + "," + y);
            
            x = nx;
            y = ny;
        }
        
        return result.size() / 2;
    }
    private void initLocation(Map<Character, int[]> location){
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        char[] command = {'U','D','R','L'};
        
        for(int i = 0; i < 4; i++){
            location.put(command[i], new int[]{dx[i], dy[i]});
        }
    }
    private boolean isValid(int nx, int ny){
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }
}