class Solution {
    public int solution(String name) {
        
        int n = name.length();
        int upDown = 0;
        int leftRight = n-1;
        
        for(int i = 0; i < n; i++){
            char c = name.charAt(i);
            int up = c - 'A';
            int down = 26 - up;
            upDown += Math.min(up, down);
            
            int next = i+1;
            while (next < n && name.charAt(next) == 'A') {
               next++;
            }
            
            int goRight = i * 2 + (n - next);
            int goLeft = (n - next) * 2 + i;
            
            leftRight = Math.min(leftRight, Math.min(goRight, goLeft));
        }
        
        
        return upDown + leftRight;
    }
}