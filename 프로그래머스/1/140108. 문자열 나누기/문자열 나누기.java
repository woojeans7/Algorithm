class Solution {
    public int solution(String s) {
        int xCount = 0;
        int otherCount = 0;
        int answer = 0;
        char x = 0;
        
        for(char c : s.toCharArray()){
            if (x == 0) x = c;
            
            if(c == x) xCount++;
            else otherCount++;
            
            if(xCount == otherCount){
                answer++;
                x = 0;
                xCount = 0;
                otherCount = 0;
            }
        }
        if (xCount > 0) answer++;
        
        return answer;
    }
}